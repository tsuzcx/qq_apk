package com.tencent.av.doodle;

import android.graphics.PointF;
import android.os.SystemClock;
import com.tencent.av.AVFunDrawing.DrawingInfo;
import com.tencent.av.AVFunDrawing.MessageBody;
import com.tencent.av.AVFunDrawing.PointInfo;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class DoodleLogic
{
  static int o;
  private static DoodleLogic p;
  ConcurrentLinkedQueue<DoodleItem> a = new ConcurrentLinkedQueue();
  DoodleItem[] b = new DoodleItem[2];
  boolean c = false;
  public int d = -65536;
  public int e = 1;
  public float f = -1.0F;
  public int g = 0;
  public int h = 0;
  ReentrantLock i = new ReentrantLock();
  boolean[] j = new boolean[2];
  public boolean k = false;
  public int l = 0;
  public final DoodleReportController m = new DoodleReportController(this);
  ConcurrentLinkedQueue<DoodleLogic.SendItemInfo> n = new ConcurrentLinkedQueue();
  private DoodleLogic.DoodleLogicListener q = null;
  
  private void a(int paramInt)
  {
    DoodleItem localDoodleItem1 = this.b[paramInt];
    if (localDoodleItem1 != null)
    {
      localDoodleItem1.i = SystemClock.elapsedRealtime();
      localObject = this.q;
      if (localObject != null) {
        ((DoodleLogic.DoodleLogicListener)localObject).a(paramInt);
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        DoodleItem localDoodleItem2 = (DoodleItem)((Iterator)localObject).next();
        if (localDoodleItem1.i - localDoodleItem2.i <= 1200L) {
          localDoodleItem2.i = localDoodleItem1.i;
        }
      }
      this.a.offer(localDoodleItem1);
    }
    this.b[paramInt] = null;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("offerDoodle, index[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], item[");
    ((StringBuilder)localObject).append(localDoodleItem1);
    ((StringBuilder)localObject).append("], size[");
    ((StringBuilder)localObject).append(this.a.size());
    ((StringBuilder)localObject).append("]");
    QLog.w("DoodleLogic", 1, ((StringBuilder)localObject).toString());
  }
  
  public static DoodleLogic b()
  {
    try
    {
      if (p == null) {
        p = new DoodleLogic();
      }
      return p;
    }
    finally {}
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.b;
    int i1 = 0;
    localObject = localObject[0];
    AVFunDrawing.PointInfo localPointInfo = new AVFunDrawing.PointInfo();
    localPointInfo.uint32_type.set(paramInt);
    AVFunDrawing.MessageBody localMessageBody = new AVFunDrawing.MessageBody();
    localMessageBody.uint32_msg_type.set(2);
    AVFunDrawing.DrawingInfo localDrawingInfo = new AVFunDrawing.DrawingInfo();
    if (localObject != null) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      float f1 = ((DoodleItem)localObject).h.x;
      float f2 = ((DoodleItem)localObject).h.y;
      localPointInfo.float_x.set(f1);
      localPointInfo.float_y.set(f2);
      localDrawingInfo.uint32_pen_type.set(((DoodleItem)localObject).b);
      localDrawingInfo.str_pen_name.set(((DoodleItem)localObject).c);
      PBStringField localPBStringField = localDrawingInfo.str_pen_color;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("#");
      localStringBuilder.append(Integer.toHexString(((DoodleItem)localObject).g));
      localPBStringField.set(localStringBuilder.toString());
      localDrawingInfo.uint32_pen_width.set(((DoodleItem)localObject).d);
      localDrawingInfo.uint32_screen_width.set(((DoodleItem)localObject).e);
      localDrawingInfo.uint32_screen_height.set(((DoodleItem)localObject).f);
    }
    else
    {
      SmallScreenUtils.a("没有doodleItem");
    }
    localDrawingInfo.msg_point_info.add(localPointInfo);
    localMessageBody.drawingInfo.set(localDrawingInfo);
    i1 = d();
    localMessageBody.uint32_seq.set(i1);
    this.n.add(new DoodleLogic.SendItemInfo(localMessageBody));
    if (paramInt == 3)
    {
      if (this.n.size() == 1) {
        a(100L);
      }
    }
    else if (this.n.size() == 1) {
      c();
    }
  }
  
  /* Error */
  public int a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 173	com/tencent/av/AVFunDrawing$MessageBody
    //   3: dup
    //   4: invokespecial 174	com/tencent/av/AVFunDrawing$MessageBody:<init>	()V
    //   7: astore 14
    //   9: aload 14
    //   11: aload_1
    //   12: invokevirtual 295	com/tencent/av/AVFunDrawing$MessageBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: astore_1
    //   16: aload_1
    //   17: checkcast 173	com/tencent/av/AVFunDrawing$MessageBody
    //   20: astore 14
    //   22: aload 14
    //   24: getfield 177	com/tencent/av/AVFunDrawing$MessageBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   27: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   30: istore 5
    //   32: iload 5
    //   34: istore 4
    //   36: iload 4
    //   38: iconst_1
    //   39: if_icmpeq +729 -> 768
    //   42: iload 4
    //   44: iconst_2
    //   45: if_icmpeq +6 -> 51
    //   48: goto +842 -> 890
    //   51: aload 14
    //   53: getfield 265	com/tencent/av/AVFunDrawing$MessageBody:drawingInfo	Lcom/tencent/av/AVFunDrawing$DrawingInfo;
    //   56: astore_1
    //   57: aload 14
    //   59: getfield 302	com/tencent/av/AVFunDrawing$MessageBody:uint64_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   62: invokevirtual 306	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   65: lstore 9
    //   67: invokestatic 310	com/tencent/av/utils/AudioHelper:b	()J
    //   70: lstore 11
    //   72: lload 11
    //   74: lload 9
    //   76: lcmp
    //   77: ifle +873 -> 950
    //   80: lload 11
    //   82: lload 9
    //   84: lsub
    //   85: l2i
    //   86: istore 6
    //   88: goto +3 -> 91
    //   91: aload_1
    //   92: getfield 255	com/tencent/av/AVFunDrawing$DrawingInfo:msg_point_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   95: invokevirtual 311	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   98: istore 7
    //   100: iload 7
    //   102: ifle +572 -> 674
    //   105: aload_1
    //   106: getfield 255	com/tencent/av/AVFunDrawing$DrawingInfo:msg_point_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   109: astore 15
    //   111: aload 15
    //   113: iconst_0
    //   114: invokevirtual 314	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   117: checkcast 161	com/tencent/av/AVFunDrawing$PointInfo
    //   120: astore 15
    //   122: aload 15
    //   124: getfield 166	com/tencent/av/AVFunDrawing$PointInfo:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: istore 8
    //   132: aload 15
    //   134: getfield 195	com/tencent/av/AVFunDrawing$PointInfo:float_x	Lcom/tencent/mobileqq/pb/PBFloatField;
    //   137: invokevirtual 317	com/tencent/mobileqq/pb/PBFloatField:get	()F
    //   140: fstore_2
    //   141: aload 15
    //   143: getfield 203	com/tencent/av/AVFunDrawing$PointInfo:float_y	Lcom/tencent/mobileqq/pb/PBFloatField;
    //   146: invokevirtual 317	com/tencent/mobileqq/pb/PBFloatField:get	()F
    //   149: fstore_3
    //   150: aload_0
    //   151: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   154: iconst_1
    //   155: aaload
    //   156: astore 16
    //   158: iload 8
    //   160: iconst_1
    //   161: if_icmpne +22 -> 183
    //   164: aload_0
    //   165: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   168: iconst_1
    //   169: aload_1
    //   170: getfield 206	com/tencent/av/AVFunDrawing$DrawingInfo:uint32_pen_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   173: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   176: invokestatic 322	com/tencent/av/doodle/DoodleUtils:a	(I)Lcom/tencent/av/doodle/DoodleItem;
    //   179: aastore
    //   180: goto +783 -> 963
    //   183: aload 16
    //   185: ifnonnull +778 -> 963
    //   188: aload_0
    //   189: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   192: iconst_1
    //   193: aload_1
    //   194: getfield 206	com/tencent/av/AVFunDrawing$DrawingInfo:uint32_pen_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   197: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   200: invokestatic 322	com/tencent/av/doodle/DoodleUtils:a	(I)Lcom/tencent/av/doodle/DoodleItem;
    //   203: aastore
    //   204: iload 8
    //   206: iconst_2
    //   207: if_icmpne +756 -> 963
    //   210: iconst_1
    //   211: istore 7
    //   213: goto +3 -> 216
    //   216: new 120	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   223: astore 15
    //   225: aload 15
    //   227: ldc_w 324
    //   230: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 15
    //   236: iload 8
    //   238: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 15
    //   244: ldc_w 326
    //   247: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 15
    //   253: iload 7
    //   255: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 15
    //   261: ldc_w 328
    //   264: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 15
    //   270: fload_2
    //   271: invokevirtual 331	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 15
    //   277: ldc_w 333
    //   280: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 15
    //   286: fload_3
    //   287: invokevirtual 331	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 15
    //   293: ldc_w 335
    //   296: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 15
    //   302: aload 14
    //   304: getfield 272	com/tencent/av/AVFunDrawing$MessageBody:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   307: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   310: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 15
    //   316: ldc_w 337
    //   319: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 15
    //   325: iload 6
    //   327: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 15
    //   333: ldc_w 339
    //   336: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 15
    //   342: lload 11
    //   344: invokevirtual 342	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 15
    //   350: ldc_w 344
    //   353: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 15
    //   359: lload 9
    //   361: invokevirtual 342	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 15
    //   367: ldc_w 346
    //   370: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 15
    //   376: aload 16
    //   378: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 15
    //   384: ldc_w 348
    //   387: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_0
    //   392: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   395: astore 14
    //   397: aload 15
    //   399: aload 14
    //   401: iconst_1
    //   402: aaload
    //   403: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 15
    //   409: ldc 143
    //   411: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 15
    //   417: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: astore 15
    //   422: ldc 145
    //   424: astore 14
    //   426: aload 14
    //   428: iconst_1
    //   429: aload 15
    //   431: invokestatic 155	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload_0
    //   435: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   438: iconst_1
    //   439: aaload
    //   440: ifnonnull +6 -> 446
    //   443: goto +447 -> 890
    //   446: aload_0
    //   447: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   450: iconst_1
    //   451: aaload
    //   452: aload_1
    //   453: getfield 212	com/tencent/av/AVFunDrawing$DrawingInfo:str_pen_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   456: invokevirtual 350	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   459: putfield 215	com/tencent/av/doodle/DoodleItem:c	Ljava/lang/String;
    //   462: aload_0
    //   463: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   466: iconst_1
    //   467: aaload
    //   468: astore 15
    //   470: aload 15
    //   472: aload_1
    //   473: getfield 223	com/tencent/av/AVFunDrawing$DrawingInfo:str_pen_color	Lcom/tencent/mobileqq/pb/PBStringField;
    //   476: invokevirtual 350	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   479: invokestatic 356	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   482: putfield 226	com/tencent/av/doodle/DoodleItem:g	I
    //   485: aload_0
    //   486: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   489: astore 15
    //   491: aload 15
    //   493: iconst_1
    //   494: aaload
    //   495: aload_1
    //   496: getfield 235	com/tencent/av/AVFunDrawing$DrawingInfo:uint32_pen_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   499: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   502: putfield 236	com/tencent/av/doodle/DoodleItem:d	I
    //   505: aload_0
    //   506: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   509: iconst_1
    //   510: aaload
    //   511: aload_1
    //   512: getfield 239	com/tencent/av/AVFunDrawing$DrawingInfo:uint32_screen_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   515: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   518: putfield 240	com/tencent/av/doodle/DoodleItem:e	I
    //   521: aload_0
    //   522: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   525: iconst_1
    //   526: aaload
    //   527: aload_1
    //   528: getfield 243	com/tencent/av/AVFunDrawing$DrawingInfo:uint32_screen_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   531: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   534: putfield 245	com/tencent/av/doodle/DoodleItem:f	I
    //   537: iload 7
    //   539: iconst_1
    //   540: if_icmpeq +38 -> 578
    //   543: iload 7
    //   545: iconst_2
    //   546: if_icmpeq +22 -> 568
    //   549: iload 7
    //   551: iconst_3
    //   552: if_icmpeq +6 -> 558
    //   555: goto +44 -> 599
    //   558: aload_0
    //   559: iconst_1
    //   560: fload_2
    //   561: fload_3
    //   562: invokevirtual 359	com/tencent/av/doodle/DoodleLogic:c	(IFF)V
    //   565: goto +34 -> 599
    //   568: aload_0
    //   569: iconst_1
    //   570: fload_2
    //   571: fload_3
    //   572: invokevirtual 361	com/tencent/av/doodle/DoodleLogic:b	(IFF)V
    //   575: goto +24 -> 599
    //   578: ldc_w 363
    //   581: invokestatic 369	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   584: checkcast 363	com/tencent/av/doodle/api/IDoodleApi
    //   587: invokeinterface 372 1 0
    //   592: aload_0
    //   593: iconst_1
    //   594: fload_2
    //   595: fload_3
    //   596: invokevirtual 374	com/tencent/av/doodle/DoodleLogic:a	(IFF)V
    //   599: new 120	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   606: astore_1
    //   607: aload_1
    //   608: ldc_w 376
    //   611: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_0
    //   616: getfield 48	com/tencent/av/doodle/DoodleLogic:b	[Lcom/tencent/av/doodle/DoodleItem;
    //   619: astore 15
    //   621: aload_1
    //   622: aload 15
    //   624: iconst_1
    //   625: aaload
    //   626: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload_1
    //   631: ldc 143
    //   633: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: pop
    //   637: aload 14
    //   639: iconst_1
    //   640: aload_1
    //   641: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 155	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: goto +243 -> 890
    //   650: astore_1
    //   651: goto +4 -> 655
    //   654: astore_1
    //   655: goto +282 -> 937
    //   658: astore_1
    //   659: goto +235 -> 894
    //   662: astore_1
    //   663: goto +239 -> 902
    //   666: astore_1
    //   667: goto +227 -> 894
    //   670: astore_1
    //   671: goto +231 -> 902
    //   674: new 120	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   681: astore_1
    //   682: aload_1
    //   683: ldc_w 378
    //   686: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload_1
    //   691: aload 14
    //   693: getfield 272	com/tencent/av/AVFunDrawing$MessageBody:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   696: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   699: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload_1
    //   704: ldc_w 337
    //   707: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload_1
    //   712: iload 6
    //   714: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload_1
    //   719: ldc_w 339
    //   722: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_1
    //   727: lload 11
    //   729: invokevirtual 342	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: aload_1
    //   734: ldc_w 344
    //   737: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload_1
    //   742: lload 9
    //   744: invokevirtual 342	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload_1
    //   749: ldc 143
    //   751: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: ldc 145
    //   757: iconst_1
    //   758: aload_1
    //   759: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 155	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: goto +125 -> 890
    //   768: iconst_0
    //   769: istore 13
    //   771: aload 14
    //   773: getfield 382	com/tencent/av/AVFunDrawing$MessageBody:versionInfo	Lcom/tencent/av/AVFunDrawing$VersionInfo;
    //   776: astore_1
    //   777: aload_0
    //   778: aload_1
    //   779: getfield 387	com/tencent/av/AVFunDrawing$VersionInfo:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   782: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   785: putfield 75	com/tencent/av/doodle/DoodleLogic:l	I
    //   788: aload_1
    //   789: getfield 390	com/tencent/av/AVFunDrawing$VersionInfo:uint32_support_drawing	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   792: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   795: ifeq +6 -> 801
    //   798: iconst_1
    //   799: istore 13
    //   801: aload_0
    //   802: iload 13
    //   804: putfield 73	com/tencent/av/doodle/DoodleLogic:k	Z
    //   807: new 120	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   814: astore_1
    //   815: aload_1
    //   816: ldc_w 392
    //   819: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload_1
    //   824: aload_0
    //   825: getfield 75	com/tencent/av/doodle/DoodleLogic:l	I
    //   828: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload_1
    //   833: ldc_w 394
    //   836: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: aload_1
    //   841: aload_0
    //   842: getfield 73	com/tencent/av/doodle/DoodleLogic:k	Z
    //   845: invokevirtual 397	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload_1
    //   850: ldc_w 335
    //   853: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload_1
    //   858: aload 14
    //   860: getfield 272	com/tencent/av/AVFunDrawing$MessageBody:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   863: invokevirtual 298	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   866: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload_1
    //   871: ldc 143
    //   873: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: ldc 145
    //   879: iconst_1
    //   880: aload_1
    //   881: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: invokestatic 155	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   887: invokestatic 399	com/tencent/av/smallscreen/SmallScreenUtils:a	()V
    //   890: iload 5
    //   892: ireturn
    //   893: astore_1
    //   894: iload 5
    //   896: istore 4
    //   898: goto +22 -> 920
    //   901: astore_1
    //   902: iload 5
    //   904: istore 4
    //   906: goto +7 -> 913
    //   909: astore_1
    //   910: iconst_0
    //   911: istore 4
    //   913: goto +24 -> 937
    //   916: astore_1
    //   917: iconst_0
    //   918: istore 4
    //   920: ldc 145
    //   922: iconst_1
    //   923: ldc_w 401
    //   926: aload_1
    //   927: invokestatic 404	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   930: iload 4
    //   932: ireturn
    //   933: astore_1
    //   934: iconst_0
    //   935: istore 4
    //   937: ldc 145
    //   939: iconst_1
    //   940: ldc_w 406
    //   943: aload_1
    //   944: invokestatic 404	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   947: iload 4
    //   949: ireturn
    //   950: iconst_0
    //   951: lload 9
    //   953: lload 11
    //   955: lsub
    //   956: l2i
    //   957: isub
    //   958: istore 6
    //   960: goto -869 -> 91
    //   963: iload 8
    //   965: istore 7
    //   967: goto -751 -> 216
    //   970: astore_1
    //   971: goto -51 -> 920
    //   974: astore_1
    //   975: goto -62 -> 913
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	this	DoodleLogic
    //   0	978	1	paramArrayOfByte	byte[]
    //   140	455	2	f1	float
    //   149	447	3	f2	float
    //   34	914	4	i1	int
    //   30	873	5	i2	int
    //   86	873	6	i3	int
    //   98	868	7	i4	int
    //   130	834	8	i5	int
    //   65	887	9	l1	long
    //   70	884	11	l2	long
    //   769	34	13	bool	boolean
    //   7	852	14	localObject1	Object
    //   109	514	15	localObject2	Object
    //   156	221	16	localDoodleItem	DoodleItem
    // Exception table:
    //   from	to	target	type
    //   426	443	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   446	470	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   491	537	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   558	565	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   568	575	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   592	599	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   621	647	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   397	422	654	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   132	158	658	java/lang/Exception
    //   164	180	658	java/lang/Exception
    //   188	204	658	java/lang/Exception
    //   216	397	658	java/lang/Exception
    //   397	422	658	java/lang/Exception
    //   132	158	662	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   164	180	662	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   188	204	662	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   216	397	662	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   111	132	666	java/lang/Exception
    //   111	132	670	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   426	443	893	java/lang/Exception
    //   446	470	893	java/lang/Exception
    //   470	491	893	java/lang/Exception
    //   491	537	893	java/lang/Exception
    //   558	565	893	java/lang/Exception
    //   568	575	893	java/lang/Exception
    //   578	592	893	java/lang/Exception
    //   592	599	893	java/lang/Exception
    //   599	621	893	java/lang/Exception
    //   621	647	893	java/lang/Exception
    //   674	765	893	java/lang/Exception
    //   771	788	893	java/lang/Exception
    //   788	798	893	java/lang/Exception
    //   801	890	893	java/lang/Exception
    //   470	491	901	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   578	592	901	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   599	621	901	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   674	765	901	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   771	788	901	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   788	798	901	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   801	890	901	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   16	32	909	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   9	16	916	java/lang/Exception
    //   16	32	916	java/lang/Exception
    //   9	16	933	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   51	72	970	java/lang/Exception
    //   91	100	970	java/lang/Exception
    //   105	111	970	java/lang/Exception
    //   51	72	974	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   91	100	974	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   105	111	974	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a()
  {
    this.a.clear();
    Object localObject = this.b;
    localObject[0] = null;
    localObject[1] = null;
    this.k = false;
    this.l = 0;
    this.d = -65536;
    this.f = -1.0F;
    localObject = this.j;
    localObject[0] = 0;
    localObject[1] = 0;
    int i1 = this.n.size();
    this.n.clear();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resetDoodle, mSendQuene[");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("]");
    QLog.w("DoodleLogic", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
  }
  
  void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.i.lock();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    try
    {
      this.c = bool;
      this.j[paramInt] = true;
      if (this.c)
      {
        this.b[0] = DoodleUtils.a(this.e);
        this.b[0].g = this.d;
        this.b[0].b = this.e;
        this.b[0].e = this.g;
        this.b[0].f = this.h;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("touch_start, index[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], item[");
      localStringBuilder.append(this.b[paramInt]);
      localStringBuilder.append("], pt[");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("]");
      QLog.w("DoodleLogic", 1, localStringBuilder.toString());
      this.b[paramInt].a(paramFloat1, paramFloat2);
      if (this.c) {
        b(1);
      }
      if (this.q != null) {
        this.q.invalidate();
      }
      return;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  void a(long paramLong)
  {
    if (AudioHelper.e())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startSendDoodleHandle, delayMillis[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("DoodleLogic", 1, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().postDelayed(new DoodleLogic.1(this), paramLong);
  }
  
  void a(DoodleLogic.DoodleLogicListener paramDoodleLogicListener)
  {
    this.q = paramDoodleLogicListener;
  }
  
  void b(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.i.lock();
    for (;;)
    {
      try
      {
        if ((this.b[paramInt] != null) && (this.b[paramInt].b(paramFloat1, paramFloat2)))
        {
          if (paramInt != 0) {
            break label94;
          }
          bool = true;
          this.c = bool;
          if (this.c) {
            b(2);
          }
          if (this.q != null) {
            this.q.invalidate();
          }
        }
        return;
      }
      finally
      {
        this.i.unlock();
      }
      label94:
      boolean bool = false;
    }
  }
  
  public void b(long paramLong)
  {
    DoodleItem[] arrayOfDoodleItem = this.b;
    int i2 = arrayOfDoodleItem.length;
    int i1 = 0;
    while (i1 < i2)
    {
      DoodleItem localDoodleItem = arrayOfDoodleItem[i1];
      if (localDoodleItem != null) {
        localDoodleItem.a(paramLong);
      }
      i1 += 1;
    }
  }
  
  void c()
  {
    DoodleLogic.SendItemInfo localSendItemInfo = (DoodleLogic.SendItemInfo)this.n.poll();
    if (localSendItemInfo == null)
    {
      QLog.w("DoodleLogic", 1, "sendDoodle, 结束");
      return;
    }
    AVFunDrawing.MessageBody localMessageBody = localSendItemInfo.a;
    long l1 = AudioHelper.b();
    localMessageBody.uint64_time.set(l1);
    Object localObject = localMessageBody.toByteArray();
    ((IDoodleApi)QRoute.api(IDoodleApi.class)).sendAVFunChatMsg(2, (byte[])localObject);
    localObject = (AVFunDrawing.PointInfo)((AVFunDrawing.DrawingInfo)localMessageBody.drawingInfo.get()).msg_point_info.get(0);
    float f1 = ((AVFunDrawing.PointInfo)localObject).float_x.get();
    float f2 = ((AVFunDrawing.PointInfo)localObject).float_y.get();
    int i1 = ((AVFunDrawing.PointInfo)localObject).uint32_type.get();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendDoodle, sendtime[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("], offset[");
    ((StringBuilder)localObject).append(l1 - localSendItemInfo.b);
    ((StringBuilder)localObject).append("], pt[");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(f2);
    ((StringBuilder)localObject).append("], uint32_type[");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append("], uint32_seq[");
    ((StringBuilder)localObject).append(localMessageBody.uint32_seq.get());
    ((StringBuilder)localObject).append("], size[");
    ((StringBuilder)localObject).append(this.n.size());
    ((StringBuilder)localObject).append("]");
    QLog.w("DoodleLogic", 1, ((StringBuilder)localObject).toString());
    if (this.n.size() > 0) {
      a(1L);
    }
  }
  
  void c(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.i.lock();
    for (;;)
    {
      boolean bool;
      try
      {
        if (this.b[paramInt] == null) {
          break label192;
        }
        this.b[paramInt].d(paramFloat1, paramFloat2);
      }
      finally
      {
        StringBuilder localStringBuilder;
        this.i.unlock();
      }
      this.c = bool;
      if (this.c) {
        b(3);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("touch_up, index[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], item[");
      localStringBuilder.append(this.b[paramInt]);
      localStringBuilder.append("], pt[");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("]");
      QLog.w("DoodleLogic", 1, localStringBuilder.toString());
      a(paramInt);
      if (this.q != null) {
        this.q.invalidate();
      }
      this.j[paramInt] = false;
      this.i.unlock();
      return;
      label192:
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  int d()
  {
    try
    {
      o += 1;
      int i1 = o;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public DoodleLogic.DoodleLogicListener f()
  {
    return this.q;
  }
  
  public boolean g()
  {
    return this.l > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleLogic
 * JD-Core Version:    0.7.0.1
 */