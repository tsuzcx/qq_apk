package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public abstract class TroopGiftMsgItemBuilder
  extends BaseBubbleBuilder
{
  private static int C = 101;
  private static int D = 102;
  public static List<MessageForTroopGift> a = new LinkedList();
  public static String x = "TroopGiftMsgItemBuilder";
  Map<String, Boolean> A = new HashMap();
  Map<String, ArrayList<Runnable>> B = new HashMap();
  BaseChatPie w;
  AtomicInteger y = new AtomicInteger(0);
  Handler z = new TroopGiftMsgItemBuilder.1(this);
  
  public TroopGiftMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.w = paramBaseChatPie;
  }
  
  @NotNull
  private Bitmap a(Bitmap paramBitmap, BubbleImageView paramBubbleImageView, int paramInt)
  {
    Object localObject1 = this.d.getApp().getResources().getDisplayMetrics();
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).postScale(1.0F, 1.0F);
    int m = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    double d = m;
    Double.isNaN(d);
    int j = (int)(d * 0.357D);
    d = i;
    Double.isNaN(d);
    int k = (int)(d * 0.357D);
    d = m - 1;
    Double.isNaN(d);
    m = (int)(d * 0.642D);
    d = i - 1;
    Double.isNaN(d);
    paramBitmap = Bitmap.createBitmap(paramBitmap, j, k, m, (int)(d * 0.642D), (Matrix)localObject2, true);
    i = paramBubbleImageView.getLayoutParams().width;
    j = (int)(((DisplayMetrics)localObject1).density * 150.0F);
    paramBubbleImageView = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
    localObject2 = new Canvas(paramBubbleImageView);
    localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    ((Canvas)localObject2).drawRect(0.0F, 0.0F, i, j, (Paint)localObject1);
    if (paramInt != 0)
    {
      localObject2 = new Canvas(paramBubbleImageView);
      ((Canvas)localObject2).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, i, j), (Paint)localObject1);
      ((Paint)localObject1).setColor(paramInt);
      ((Canvas)localObject2).drawRect(0.0F, 0.0F, paramBubbleImageView.getWidth(), paramBubbleImageView.getHeight(), (Paint)localObject1);
      StackBlur.a(paramBubbleImageView, 60);
    }
    return paramBubbleImageView;
  }
  
  @NotNull
  private MessageForTroopGift a(MessageForTroopGift paramMessageForTroopGift, TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder)
  {
    boolean bool = AnonymousChatHelper.a().a(this.f.b);
    if (paramMessageForTroopGift.senderUin != this.d.getLongAccountUin())
    {
      if (paramMessageForTroopGift.receiverUin == this.d.getLongAccountUin())
      {
        paramTroopGiftMsgHolder.u.setVisibility(8);
        paramTroopGiftMsgHolder.t.setVisibility(0);
        paramTroopGiftMsgHolder.v.setVisibility(8);
      }
      else
      {
        paramTroopGiftMsgHolder.u.setVisibility(0);
        paramTroopGiftMsgHolder.t.setVisibility(8);
        paramTroopGiftMsgHolder.v.setVisibility(8);
      }
    }
    else
    {
      paramTroopGiftMsgHolder.u.setVisibility(8);
      paramTroopGiftMsgHolder.t.setVisibility(8);
      paramTroopGiftMsgHolder.v.setVisibility(8);
    }
    if ((paramMessageForTroopGift.btFlag == 0) || (bool))
    {
      paramTroopGiftMsgHolder.u.setVisibility(8);
      paramTroopGiftMsgHolder.t.setVisibility(8);
    }
    if (paramMessageForTroopGift.btFlag == 1) {
      paramTroopGiftMsgHolder.u.setVisibility(8);
    }
    if (paramMessageForTroopGift.btFlag == 2) {
      paramTroopGiftMsgHolder.t.setVisibility(8);
    }
    if (((paramMessageForTroopGift.receiverUin != this.d.getLongAccountUin()) || (paramMessageForTroopGift.senderUin == this.d.getLongAccountUin()) || ((paramMessageForTroopGift.receiverUin == this.d.getLongAccountUin()) && (paramMessageForTroopGift.btFlag == 0))) && (paramMessageForTroopGift.is_activity_gift == 1) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_text)) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_text_color)) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_url)))
    {
      paramTroopGiftMsgHolder.v.setVisibility(0);
      paramTroopGiftMsgHolder.u.setVisibility(8);
      paramTroopGiftMsgHolder.t.setVisibility(8);
      paramTroopGiftMsgHolder.w.setText(paramMessageForTroopGift.activity_text);
      paramTroopGiftMsgHolder.w.setTextColor(Color.parseColor(paramMessageForTroopGift.activity_text_color));
    }
    return paramMessageForTroopGift;
  }
  
  private void a(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder)
  {
    if (((paramTroopGiftMsgHolder.t.getVisibility() == 8) && (paramTroopGiftMsgHolder.u.getVisibility() == 8) && (paramTroopGiftMsgHolder.v.getVisibility() == 8)) || (this.o)) {
      paramTroopGiftMsgHolder.f.getLayoutParams().height = ((int)(this.k * 100.0F));
    } else {
      paramTroopGiftMsgHolder.f.getLayoutParams().height = ((int)(this.k * 142.0F));
    }
    if (this.o)
    {
      paramTroopGiftMsgHolder.u.setVisibility(8);
      paramTroopGiftMsgHolder.t.setVisibility(8);
      paramTroopGiftMsgHolder.u.setVisibility(8);
    }
  }
  
  private void a(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, MessageForTroopGift paramMessageForTroopGift)
  {
    if ((AppSetting.e) && (!TextUtils.isEmpty(paramMessageForTroopGift.title)))
    {
      String str = paramMessageForTroopGift.title;
      paramMessageForTroopGift = str;
      if (paramTroopGiftMsgHolder.c != null)
      {
        paramMessageForTroopGift = str;
        if (!TextUtils.isEmpty(paramTroopGiftMsgHolder.c.getText()))
        {
          paramMessageForTroopGift = new StringBuilder();
          paramMessageForTroopGift.append(str);
          paramMessageForTroopGift.append(paramTroopGiftMsgHolder.c.getText().toString());
          paramMessageForTroopGift = paramMessageForTroopGift.toString();
        }
      }
      paramTroopGiftMsgHolder.f.setContentDescription(paramMessageForTroopGift);
    }
  }
  
  private void a(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, MessageForTroopGift paramMessageForTroopGift, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 2))
    {
      paramURLDrawable.restartDownload();
      return;
    }
    if (paramURLDrawable != null) {
      if ((paramURLDrawable.getCurrDrawable() instanceof RegionDrawable))
      {
        int j = paramMessageForTroopGift.objColor;
        int i = j;
        if (j == 0) {
          i = -2138570752;
        }
        if (TextUtils.isEmpty(paramMessageForTroopGift.interactId))
        {
          paramURLDrawable = ((RegionDrawable)paramURLDrawable.getCurrDrawable()).getBitmap();
          paramTroopGiftMsgHolder = paramTroopGiftMsgHolder.f;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramMessageForTroopGift.giftPicId);
          localStringBuilder.append("");
          a(paramURLDrawable, i, paramTroopGiftMsgHolder, localStringBuilder.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        paramTroopGiftMsgHolder = new StringBuilder();
        paramTroopGiftMsgHolder.append("drawable.getCurrDrawable() instanceof  RegionDrawable = ");
        paramTroopGiftMsgHolder.append(paramURLDrawable.getCurrDrawable() instanceof RegionDrawable);
        QLog.e("TroopGiftMsgItemBuilder", 2, paramTroopGiftMsgHolder.toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!a.isEmpty()) {
      ThreadManager.post(new TroopGiftMsgItemBuilder.8(paramQQAppInterface.getEntityManagerFactory().createEntityManager()), 5, null, true);
    }
  }
  
  private void a(MessageForTroopGift paramMessageForTroopGift)
  {
    if (!paramMessageForTroopGift.isReported)
    {
      int j = 1;
      paramMessageForTroopGift.isReported = true;
      a.add(paramMessageForTroopGift);
      int i;
      if (this.d.getCurrentUin().equals(paramMessageForTroopGift.senderuin)) {
        i = 0;
      } else if (this.d.getCurrentUin().equals(Long.valueOf(paramMessageForTroopGift.receiverUin))) {
        i = 1;
      } else {
        i = 2;
      }
      if (paramMessageForTroopGift.istroop == 0)
      {
        ReportController.b(this.d, "dc00899", "Grp_flower", "", "C2C", "exp_obj", 0, 0, "", "", "", "");
        return;
      }
      if (paramMessageForTroopGift.istroop == 3000)
      {
        ReportController.b(this.d, "dc00899", "Grp_flower", "", "discuss_grp", "exp_obj", 0, 0, "", "", "", "");
        return;
      }
      if ((paramMessageForTroopGift.istroop != 1000) && (paramMessageForTroopGift.istroop != 1004))
      {
        Object localObject1;
        Object localObject2;
        if (paramMessageForTroopGift.isFromNearby)
        {
          localObject1 = this.f.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append("");
          NearbyFlowerManager.a("gift_aio", "exp_obj", (String)localObject1, ((StringBuilder)localObject2).toString(), "", "");
          if (TroopGiftUtil.c(paramMessageForTroopGift))
          {
            paramMessageForTroopGift = this.f.b;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append("");
            NearbyFlowerManager.a("gift_aio", "exp_play", paramMessageForTroopGift, ((StringBuilder)localObject1).toString(), "", "");
          }
        }
        else
        {
          if (AnonymousChatHelper.c(paramMessageForTroopGift)) {
            j = 2;
          }
          localObject1 = this.d;
          localObject2 = this.f.b;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("");
          localObject3 = ((StringBuilder)localObject3).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramMessageForTroopGift.giftPicId);
          localStringBuilder.append("");
          ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_obj", j, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
          if (TroopGiftUtil.c(paramMessageForTroopGift))
          {
            localObject1 = this.d;
            localObject2 = this.f.b;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append("");
            localObject3 = ((StringBuilder)localObject3).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramMessageForTroopGift.giftPicId);
            localStringBuilder.append("");
            ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_play", j, 0, (String)localObject2, (String)localObject3, localStringBuilder.toString(), "");
          }
        }
      }
      else
      {
        ReportController.b(this.d, "dc00899", "Grp_flower", "", "temp_c2c", "exp_obj", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void a(BubbleImageView paramBubbleImageView, int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(paramInt);
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(paramInt);
    paramBubbleImageView.setImageDrawable(URLDrawable.getDrawable(new File(a(paramString, paramInt)), localURLDrawableOptions));
  }
  
  private void a(BubbleImageView paramBubbleImageView, String paramString, int paramInt)
  {
    if (paramBubbleImageView.getTag(2131441539).equals(paramString)) {
      a(paramBubbleImageView, paramInt, paramString);
    }
  }
  
  /* Error */
  private void a(String paramString1, int paramInt, Bitmap paramBitmap, BubbleImageView paramBubbleImageView, String paramString2, SharedPreferences paramSharedPreferences, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +45 -> 48
    //   6: new 306	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   13: astore 9
    //   15: aload 9
    //   17: ldc_w 527
    //   20: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 9
    //   26: aload_0
    //   27: aload_1
    //   28: iload_2
    //   29: invokevirtual 500	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   32: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc_w 529
    //   39: iconst_2
    //   40: aload 9
    //   42: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 532	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: aload_0
    //   50: aload_3
    //   51: aload 4
    //   53: iload_2
    //   54: invokespecial 534	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	(Landroid/graphics/Bitmap;Lcom/tencent/mobileqq/widget/BubbleImageView;I)Landroid/graphics/Bitmap;
    //   57: aload_1
    //   58: iload_2
    //   59: aload 5
    //   61: invokespecial 537	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	(Landroid/graphics/Bitmap;Ljava/lang/String;ILjava/lang/String;)Z
    //   64: ifeq +33 -> 97
    //   67: aload 6
    //   69: invokeinterface 543 1 0
    //   74: aload 5
    //   76: lload 7
    //   78: invokeinterface 549 4 0
    //   83: pop
    //   84: aload 6
    //   86: invokeinterface 543 1 0
    //   91: invokeinterface 552 1 0
    //   96: pop
    //   97: getstatic 555	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:h	Landroid/os/Handler;
    //   100: new 557	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$4
    //   103: dup
    //   104: aload_0
    //   105: aload 5
    //   107: aload 4
    //   109: aload_1
    //   110: iload_2
    //   111: invokespecial 560	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$4:<init>	(Lcom/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder;Ljava/lang/String;Lcom/tencent/mobileqq/widget/BubbleImageView;Ljava/lang/String;I)V
    //   114: invokevirtual 565	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   117: pop
    //   118: goto +104 -> 222
    //   121: astore_1
    //   122: goto +117 -> 239
    //   125: astore_1
    //   126: aload 6
    //   128: invokeinterface 543 1 0
    //   133: aload 5
    //   135: lconst_0
    //   136: invokeinterface 549 4 0
    //   141: pop
    //   142: aload 6
    //   144: invokeinterface 543 1 0
    //   149: invokeinterface 552 1 0
    //   154: pop
    //   155: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +64 -> 222
    //   161: ldc_w 567
    //   164: iconst_2
    //   165: aload_1
    //   166: invokevirtual 570	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   169: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: goto +50 -> 222
    //   175: astore_1
    //   176: aload 6
    //   178: invokeinterface 543 1 0
    //   183: aload 5
    //   185: lconst_0
    //   186: invokeinterface 549 4 0
    //   191: pop
    //   192: aload 6
    //   194: invokeinterface 543 1 0
    //   199: invokeinterface 552 1 0
    //   204: pop
    //   205: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +14 -> 222
    //   211: ldc_w 567
    //   214: iconst_2
    //   215: aload_1
    //   216: invokevirtual 573	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: getfield 64	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:A	Ljava/util/Map;
    //   226: aload 5
    //   228: iconst_0
    //   229: invokestatic 578	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   232: invokeinterface 584 3 0
    //   237: pop
    //   238: return
    //   239: aload_0
    //   240: getfield 64	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:A	Ljava/util/Map;
    //   243: aload 5
    //   245: iconst_0
    //   246: invokestatic 578	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   249: invokeinterface 584 3 0
    //   254: pop
    //   255: aload_1
    //   256: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	TroopGiftMsgItemBuilder
    //   0	257	1	paramString1	String
    //   0	257	2	paramInt	int
    //   0	257	3	paramBitmap	Bitmap
    //   0	257	4	paramBubbleImageView	BubbleImageView
    //   0	257	5	paramString2	String
    //   0	257	6	paramSharedPreferences	SharedPreferences
    //   0	257	7	paramLong	long
    //   13	28	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	48	121	finally
    //   48	97	121	finally
    //   97	118	121	finally
    //   126	172	121	finally
    //   176	222	121	finally
    //   0	48	125	java/lang/OutOfMemoryError
    //   48	97	125	java/lang/OutOfMemoryError
    //   97	118	125	java/lang/OutOfMemoryError
    //   0	48	175	java/lang/Exception
    //   48	97	175	java/lang/Exception
    //   97	118	175	java/lang/Exception
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 306	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 307	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: getstatic 591	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   14: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 7
    //   20: ldc_w 593
    //   23: invokevirtual 311	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: new 497	java/io/File
    //   30: dup
    //   31: aload 7
    //   33: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 599	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokespecial 503	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: invokevirtual 602	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: new 497	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: aload_2
    //   52: iload_3
    //   53: invokevirtual 500	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   56: invokespecial 503	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 10
    //   61: aload 10
    //   63: invokevirtual 605	java/io/File:exists	()Z
    //   66: ifne +17 -> 83
    //   69: aload 10
    //   71: invokevirtual 608	java/io/File:createNewFile	()Z
    //   74: pop
    //   75: goto +8 -> 83
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 611	java/io/IOException:printStackTrace	()V
    //   83: aconst_null
    //   84: astore 8
    //   86: aconst_null
    //   87: astore 9
    //   89: aconst_null
    //   90: astore_2
    //   91: new 613	java/io/BufferedOutputStream
    //   94: dup
    //   95: new 615	java/io/FileOutputStream
    //   98: dup
    //   99: aload 10
    //   101: invokespecial 618	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: sipush 8192
    //   107: invokespecial 621	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   110: astore 7
    //   112: aload_1
    //   113: getstatic 627	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   116: bipush 100
    //   118: aload 7
    //   120: invokevirtual 631	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   123: istore 6
    //   125: aload_0
    //   126: getfield 64	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:A	Ljava/util/Map;
    //   129: aload 4
    //   131: iconst_0
    //   132: invokestatic 578	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   135: invokeinterface 584 3 0
    //   140: pop
    //   141: aload 7
    //   143: invokevirtual 634	java/io/BufferedOutputStream:close	()V
    //   146: iload 6
    //   148: istore 5
    //   150: goto +301 -> 451
    //   153: astore_1
    //   154: iload 6
    //   156: istore 5
    //   158: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   161: ifeq +290 -> 451
    //   164: ldc_w 567
    //   167: iconst_2
    //   168: aload_1
    //   169: invokevirtual 635	java/io/IOException:getMessage	()Ljava/lang/String;
    //   172: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: iload 6
    //   177: istore 5
    //   179: goto +272 -> 451
    //   182: astore_1
    //   183: aload 7
    //   185: astore_2
    //   186: goto +326 -> 512
    //   189: astore_2
    //   190: aload 7
    //   192: astore_1
    //   193: aload_2
    //   194: astore 7
    //   196: goto +22 -> 218
    //   199: astore_2
    //   200: aload 7
    //   202: astore_1
    //   203: aload_2
    //   204: astore 7
    //   206: goto +135 -> 341
    //   209: astore_1
    //   210: goto +302 -> 512
    //   213: astore 7
    //   215: aload 8
    //   217: astore_1
    //   218: aload_1
    //   219: astore_2
    //   220: aload_0
    //   221: getfield 638	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:e	Landroid/content/Context;
    //   224: getstatic 36	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:x	Ljava/lang/String;
    //   227: iconst_0
    //   228: invokevirtual 644	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   231: astore 8
    //   233: aload_1
    //   234: astore_2
    //   235: aload 8
    //   237: invokeinterface 543 1 0
    //   242: aload 4
    //   244: lconst_0
    //   245: invokeinterface 549 4 0
    //   250: pop
    //   251: aload_1
    //   252: astore_2
    //   253: aload 8
    //   255: invokeinterface 543 1 0
    //   260: invokeinterface 552 1 0
    //   265: pop
    //   266: aload_1
    //   267: astore_2
    //   268: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +17 -> 288
    //   274: aload_1
    //   275: astore_2
    //   276: ldc_w 567
    //   279: iconst_2
    //   280: aload 7
    //   282: invokevirtual 570	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   285: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_0
    //   289: getfield 64	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:A	Ljava/util/Map;
    //   292: aload 4
    //   294: iconst_0
    //   295: invokestatic 578	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   298: invokeinterface 584 3 0
    //   303: pop
    //   304: aload_1
    //   305: ifnull +143 -> 448
    //   308: aload_1
    //   309: invokevirtual 634	java/io/BufferedOutputStream:close	()V
    //   312: goto +136 -> 448
    //   315: astore_1
    //   316: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +129 -> 448
    //   322: ldc_w 567
    //   325: iconst_2
    //   326: aload_1
    //   327: invokevirtual 635	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: goto +115 -> 448
    //   336: astore 7
    //   338: aload 9
    //   340: astore_1
    //   341: aload_1
    //   342: astore_2
    //   343: aload_0
    //   344: getfield 638	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:e	Landroid/content/Context;
    //   347: getstatic 36	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:x	Ljava/lang/String;
    //   350: iconst_0
    //   351: invokevirtual 644	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   354: astore 8
    //   356: aload_1
    //   357: astore_2
    //   358: aload 8
    //   360: invokeinterface 543 1 0
    //   365: aload 4
    //   367: lconst_0
    //   368: invokeinterface 549 4 0
    //   373: pop
    //   374: aload_1
    //   375: astore_2
    //   376: aload 8
    //   378: invokeinterface 543 1 0
    //   383: invokeinterface 552 1 0
    //   388: pop
    //   389: aload_1
    //   390: astore_2
    //   391: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +17 -> 411
    //   397: aload_1
    //   398: astore_2
    //   399: ldc_w 567
    //   402: iconst_2
    //   403: aload 7
    //   405: invokevirtual 573	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   408: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_0
    //   412: getfield 64	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:A	Ljava/util/Map;
    //   415: aload 4
    //   417: iconst_0
    //   418: invokestatic 578	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   421: invokeinterface 584 3 0
    //   426: pop
    //   427: aload_1
    //   428: ifnull +20 -> 448
    //   431: aload_1
    //   432: invokevirtual 634	java/io/BufferedOutputStream:close	()V
    //   435: goto +13 -> 448
    //   438: astore_1
    //   439: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +6 -> 448
    //   445: goto -123 -> 322
    //   448: iconst_0
    //   449: istore 5
    //   451: iload 5
    //   453: ifne +56 -> 509
    //   456: aload 10
    //   458: invokevirtual 605	java/io/File:exists	()Z
    //   461: ifeq +48 -> 509
    //   464: aload 10
    //   466: invokevirtual 647	java/io/File:delete	()Z
    //   469: pop
    //   470: aload_0
    //   471: getfield 638	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:e	Landroid/content/Context;
    //   474: getstatic 36	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:x	Ljava/lang/String;
    //   477: iconst_0
    //   478: invokevirtual 644	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   481: astore_1
    //   482: aload_1
    //   483: invokeinterface 543 1 0
    //   488: aload 4
    //   490: lconst_0
    //   491: invokeinterface 549 4 0
    //   496: pop
    //   497: aload_1
    //   498: invokeinterface 543 1 0
    //   503: invokeinterface 552 1 0
    //   508: pop
    //   509: iload 5
    //   511: ireturn
    //   512: aload_0
    //   513: getfield 64	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder:A	Ljava/util/Map;
    //   516: aload 4
    //   518: iconst_0
    //   519: invokestatic 578	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   522: invokeinterface 584 3 0
    //   527: pop
    //   528: aload_2
    //   529: ifnull +28 -> 557
    //   532: aload_2
    //   533: invokevirtual 634	java/io/BufferedOutputStream:close	()V
    //   536: goto +21 -> 557
    //   539: astore_2
    //   540: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +14 -> 557
    //   546: ldc_w 567
    //   549: iconst_2
    //   550: aload_2
    //   551: invokevirtual 635	java/io/IOException:getMessage	()Ljava/lang/String;
    //   554: invokestatic 572	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto +5 -> 562
    //   560: aload_1
    //   561: athrow
    //   562: goto -2 -> 560
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	TroopGiftMsgItemBuilder
    //   0	565	1	paramBitmap	Bitmap
    //   0	565	2	paramString1	String
    //   0	565	3	paramInt	int
    //   0	565	4	paramString2	String
    //   148	362	5	bool1	boolean
    //   123	53	6	bool2	boolean
    //   7	198	7	localObject1	Object
    //   213	68	7	localOutOfMemoryError	OutOfMemoryError
    //   336	68	7	localException	Exception
    //   84	293	8	localSharedPreferences	SharedPreferences
    //   87	252	9	localObject2	Object
    //   59	406	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   69	75	78	java/io/IOException
    //   141	146	153	java/io/IOException
    //   112	125	182	finally
    //   112	125	189	java/lang/OutOfMemoryError
    //   112	125	199	java/lang/Exception
    //   91	112	209	finally
    //   220	233	209	finally
    //   235	251	209	finally
    //   253	266	209	finally
    //   268	274	209	finally
    //   276	288	209	finally
    //   343	356	209	finally
    //   358	374	209	finally
    //   376	389	209	finally
    //   391	397	209	finally
    //   399	411	209	finally
    //   91	112	213	java/lang/OutOfMemoryError
    //   308	312	315	java/io/IOException
    //   91	112	336	java/lang/Exception
    //   431	435	438	java/io/IOException
    //   532	536	539	java/io/IOException
  }
  
  private void b(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, MessageForTroopGift paramMessageForTroopGift)
  {
    Object localObject;
    if (paramTroopGiftMsgHolder.t.getVisibility() == 0)
    {
      localObject = new ReportTask(this.d).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_tks").a(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForTroopGift.frienduin);
      localStringBuilder.append("");
      ((ReportTask)localObject).a(new String[] { localStringBuilder.toString(), "" }).a();
      localObject = new ReportTask(this.d).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_return").a(0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForTroopGift.frienduin);
      localStringBuilder.append("");
      ((ReportTask)localObject).a(new String[] { localStringBuilder.toString(), "" }).a();
    }
    if (paramTroopGiftMsgHolder.u.getVisibility() == 0)
    {
      paramTroopGiftMsgHolder = new ReportTask(this.d).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_ask").a(0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMessageForTroopGift.frienduin);
      ((StringBuilder)localObject).append("");
      paramTroopGiftMsgHolder.a(new String[] { ((StringBuilder)localObject).toString(), "" }).a();
    }
  }
  
  private void c(TroopGiftMsgItemBuilder.TroopGiftMsgHolder paramTroopGiftMsgHolder, MessageForTroopGift paramMessageForTroopGift)
  {
    if (TextUtils.isEmpty(paramMessageForTroopGift.charmHeroism)) {
      return;
    }
    paramTroopGiftMsgHolder.c.setVisibility(0);
    Object localObject = paramMessageForTroopGift.charmHeroism.replace("<", "").replace(">", "").split("\\$s");
    if ((localObject != null) && (localObject.length == 2))
    {
      String[] arrayOfString1 = localObject[0].split("\\#");
      if ((arrayOfString1 != null) && (arrayOfString1.length == 3))
      {
        String[] arrayOfString2 = localObject[1].split("\\#");
        if ((arrayOfString2 != null) && (arrayOfString2.length == 3))
        {
          long l1 = paramMessageForTroopGift.senderUin;
          long l2 = this.d.getLongAccountUin();
          localObject = "+";
          StringBuilder localStringBuilder;
          if (l1 == l2)
          {
            if (paramMessageForTroopGift.sendScore < 0) {
              localObject = "";
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(HardCodeUtil.a(2131912675));
            localStringBuilder.append(arrayOfString1[0]);
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(paramMessageForTroopGift.sendScore);
            localStringBuilder.append("");
            localStringBuilder.append(arrayOfString2[0]);
            localObject = localStringBuilder.toString();
            if (paramMessageForTroopGift.sendScore != 0) {}
          }
          else
          {
            do
            {
              for (;;)
              {
                localObject = "";
                break label455;
                if (paramMessageForTroopGift.receiverUin != this.d.getLongAccountUin()) {
                  break;
                }
                if (paramMessageForTroopGift.recvScore < 0) {
                  localObject = "";
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(HardCodeUtil.a(2131912661));
                localStringBuilder.append(arrayOfString1[1]);
                localStringBuilder.append((String)localObject);
                localStringBuilder.append(paramMessageForTroopGift.recvScore);
                localStringBuilder.append("");
                localStringBuilder.append(arrayOfString2[1]);
                localObject = localStringBuilder.toString();
                if (paramMessageForTroopGift.recvScore != 0) {
                  break label455;
                }
              }
              if (paramMessageForTroopGift.recvScore < 0) {
                localObject = "";
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(HardCodeUtil.a(2131912674));
              localStringBuilder.append(arrayOfString1[2]);
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(paramMessageForTroopGift.recvScore);
              localStringBuilder.append("");
              localStringBuilder.append(arrayOfString2[2]);
              localObject = localStringBuilder.toString();
            } while (paramMessageForTroopGift.recvScore == 0);
          }
          label455:
          paramTroopGiftMsgHolder.c.setText((CharSequence)localObject);
        }
      }
    }
  }
  
  private void j()
  {
    Object localObject = HardCodeUtil.a(2131912689);
    String str = SharedPreUtils.at(this.e, "thxWord");
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    this.w.Y.setText((CharSequence)localObject);
    this.w.Y.setSelection(this.w.Y.length());
    localObject = this.w;
    if ((localObject instanceof GameRoomChatPie)) {
      ((GameRoomChatPie)localObject).bP();
    }
  }
  
  public abstract View a(BaseChatItemLayout paramBaseChatItemLayout);
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    TroopGiftMsgItemBuilder.TroopGiftMsgHolder localTroopGiftMsgHolder = (TroopGiftMsgItemBuilder.TroopGiftMsgHolder)paramViewHolder;
    if (paramView == null)
    {
      paramBaseChatItemLayout = a(paramBaseChatItemLayout);
      localTroopGiftMsgHolder.a = ((LinearLayout)paramBaseChatItemLayout);
      localTroopGiftMsgHolder.b = ((TextView)localTroopGiftMsgHolder.a.findViewById(2131447966));
      localTroopGiftMsgHolder.c = ((TextView)localTroopGiftMsgHolder.a.findViewById(2131447965));
      localTroopGiftMsgHolder.d = ((Button)localTroopGiftMsgHolder.a.findViewById(2131447963));
      localTroopGiftMsgHolder.e = ((ImageView)localTroopGiftMsgHolder.a.findViewById(2131434253));
      localTroopGiftMsgHolder.f = ((BubbleImageView)localTroopGiftMsgHolder.a.findViewById(2131429416));
      localTroopGiftMsgHolder.g = localTroopGiftMsgHolder.a.findViewById(2131436054);
      localTroopGiftMsgHolder.s = localTroopGiftMsgHolder.a.findViewById(2131447964);
      localTroopGiftMsgHolder.x = ((Button)localTroopGiftMsgHolder.a.findViewById(2131434244));
      localTroopGiftMsgHolder.y = ((Button)localTroopGiftMsgHolder.a.findViewById(2131434243));
      localTroopGiftMsgHolder.z = ((Button)localTroopGiftMsgHolder.a.findViewById(2131434239));
      localTroopGiftMsgHolder.t = ((ViewGroup)localTroopGiftMsgHolder.a.findViewById(2131434245));
      localTroopGiftMsgHolder.u = ((ViewGroup)localTroopGiftMsgHolder.a.findViewById(2131434240));
      localTroopGiftMsgHolder.v = ((ViewGroup)localTroopGiftMsgHolder.a.findViewById(2131434242));
      localTroopGiftMsgHolder.w = ((Button)localTroopGiftMsgHolder.a.findViewById(2131434241));
      int i = (int)(this.k * 220.0F);
      int j = (int)(i - this.k * 10.0F);
      paramViewHolder = (RelativeLayout.LayoutParams)localTroopGiftMsgHolder.a.findViewById(2131434245).getLayoutParams();
      paramViewHolder.width = j;
      localTroopGiftMsgHolder.a.findViewById(2131434245).setLayoutParams(paramViewHolder);
      paramViewHolder = (LinearLayout.LayoutParams)localTroopGiftMsgHolder.a.findViewById(2131434244).getLayoutParams();
      int k = j / 2;
      paramViewHolder.width = ((int)(k - this.k * 1.0F));
      localTroopGiftMsgHolder.a.findViewById(2131434244).setLayoutParams(paramViewHolder);
      paramViewHolder = (LinearLayout.LayoutParams)localTroopGiftMsgHolder.a.findViewById(2131434243).getLayoutParams();
      paramViewHolder.width = k;
      localTroopGiftMsgHolder.a.findViewById(2131434243).setLayoutParams(paramViewHolder);
      paramViewHolder = (RelativeLayout.LayoutParams)localTroopGiftMsgHolder.a.findViewById(2131434240).getLayoutParams();
      paramViewHolder.width = j;
      localTroopGiftMsgHolder.a.findViewById(2131434240).setLayoutParams(paramViewHolder);
      paramViewHolder = (LinearLayout.LayoutParams)localTroopGiftMsgHolder.a.findViewById(2131434239).getLayoutParams();
      paramViewHolder.width = j;
      localTroopGiftMsgHolder.a.findViewById(2131434239).setLayoutParams(paramViewHolder);
      paramViewHolder = (RelativeLayout.LayoutParams)localTroopGiftMsgHolder.a.findViewById(2131429416).getLayoutParams();
      paramViewHolder.width = i;
      localTroopGiftMsgHolder.a.findViewById(2131429416).setLayoutParams(paramViewHolder);
      localTroopGiftMsgHolder.f.b(false);
      localTroopGiftMsgHolder.f.setRadius(13.0F);
      localTroopGiftMsgHolder.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localTroopGiftMsgHolder.f.c(true);
      localTroopGiftMsgHolder.f.setFocusable(false);
      localTroopGiftMsgHolder.f.setFocusableInTouchMode(false);
      localTroopGiftMsgHolder.f.setClickable(false);
    }
    else
    {
      paramBaseChatItemLayout = paramView;
    }
    localTroopGiftMsgHolder.f.v = a(paramChatMessage);
    MessageForTroopGift localMessageForTroopGift = a((MessageForTroopGift)paramChatMessage, localTroopGiftMsgHolder);
    b(localTroopGiftMsgHolder, localMessageForTroopGift);
    a(localTroopGiftMsgHolder);
    localTroopGiftMsgHolder.A = localMessageForTroopGift;
    if (!localMessageForTroopGift.isInteract())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append(localMessageForTroopGift.title);
      paramChatMessage.append(localMessageForTroopGift.subtitle);
      paramChatMessage = new ColorNickText(paramChatMessage.toString(), 16).b();
      localTroopGiftMsgHolder.b.setText(paramChatMessage);
      localTroopGiftMsgHolder.c.setVisibility(8);
      localTroopGiftMsgHolder.c.setTextColor(-1);
    }
    else
    {
      localTroopGiftMsgHolder.b.setText(localMessageForTroopGift.title);
      localTroopGiftMsgHolder.c.setVisibility(0);
      localTroopGiftMsgHolder.c.setText(localMessageForTroopGift.subtitle);
      localTroopGiftMsgHolder.c.setTextColor(-7829368);
    }
    c(localTroopGiftMsgHolder, localMessageForTroopGift);
    localTroopGiftMsgHolder.d.setText(localMessageForTroopGift.comefrom);
    localTroopGiftMsgHolder.d.setContentDescription(localMessageForTroopGift.comefrom);
    paramChatMessage = localTroopGiftMsgHolder.f;
    paramViewHolder = new StringBuilder();
    paramViewHolder.append(localMessageForTroopGift.giftPicId);
    paramViewHolder.append("");
    paramChatMessage.setTag(2131441539, paramViewHolder.toString());
    if (!localMessageForTroopGift.isInteract())
    {
      localTroopGiftMsgHolder.f.setImageDrawable(new ColorDrawable(localMessageForTroopGift.objColor));
      localTroopGiftMsgHolder.b.setTextColor(-1);
    }
    else
    {
      localTroopGiftMsgHolder.f.setImageResource(2130853354);
      localTroopGiftMsgHolder.b.setTextColor(-16777216);
    }
    Object localObject = null;
    paramView = null;
    paramChatMessage = paramView;
    paramViewHolder = localObject;
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      paramChatMessage = paramView;
      paramViewHolder = localObject;
      localURLDrawableOptions.mFailedDrawable = this.e.getResources().getDrawable(2130853353);
      paramChatMessage = paramView;
      paramViewHolder = localObject;
      localURLDrawableOptions.mLoadingDrawable = this.e.getResources().getDrawable(2130853353);
      paramChatMessage = paramView;
      paramViewHolder = localObject;
      paramView = URLDrawable.getDrawable(localMessageForTroopGift.makeGiftIconUrl(), localURLDrawableOptions);
      paramChatMessage = paramView;
      paramViewHolder = paramView;
      paramView.setDownloadListener(new TroopGiftMsgItemBuilder.5(this, paramView, localMessageForTroopGift, localTroopGiftMsgHolder));
    }
    catch (Exception paramViewHolder)
    {
      paramView = paramChatMessage;
      if (QLog.isColorLevel())
      {
        QLog.d("ChatItemBuilder", 2, paramViewHolder.getMessage());
        paramView = paramChatMessage;
      }
    }
    catch (OutOfMemoryError paramChatMessage)
    {
      paramView = paramViewHolder;
      if (QLog.isColorLevel())
      {
        QLog.d("ChatItemBuilder", 2, paramChatMessage.getMessage());
        paramView = paramViewHolder;
      }
    }
    a(localTroopGiftMsgHolder, localMessageForTroopGift, paramView);
    localTroopGiftMsgHolder.e.setImageDrawable(paramView);
    paramChatMessage = new TroopGiftMsgItemBuilder.ClickAction(this, localMessageForTroopGift, localTroopGiftMsgHolder);
    localTroopGiftMsgHolder.x.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.y.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.z.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.v.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.d.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.f.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.f.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localTroopGiftMsgHolder.f.setOnTouchListener(new TroopGiftMsgItemBuilder.6(this, paramOnLongClickAndTouchListener));
    localTroopGiftMsgHolder.g.setOnClickListener(paramChatMessage);
    localTroopGiftMsgHolder.g.setOnLongClickListener(paramOnLongClickAndTouchListener);
    localTroopGiftMsgHolder.g.setOnTouchListener(new TroopGiftMsgItemBuilder.7(this, paramOnLongClickAndTouchListener));
    paramChatMessage = (AIOAnimationControlManager)this.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if ((localMessageForTroopGift.isLoading) && (paramChatMessage.d(TroopGiftUtil.b(localMessageForTroopGift))))
    {
      paramChatMessage.a(localTroopGiftMsgHolder);
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("VISIBLE uniseq = ");
        paramChatMessage.append(localMessageForTroopGift.uniseq);
        QLog.d("ChatItemBuilder", 2, paramChatMessage.toString());
      }
      localTroopGiftMsgHolder.s.setVisibility(0);
    }
    else
    {
      localTroopGiftMsgHolder.s.setVisibility(8);
      paramChatMessage.b(localTroopGiftMsgHolder);
    }
    a(localMessageForTroopGift);
    a(localTroopGiftMsgHolder, localMessageForTroopGift);
    return paramBaseChatItemLayout;
  }
  
  public String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".gift/");
    localStringBuilder.append("troopGift_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(".png");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  public void a(Bitmap paramBitmap, int paramInt, BubbleImageView paramBubbleImageView, String paramString)
  {
    if ((paramBitmap != null) && (paramBubbleImageView != null))
    {
      if (paramString == null) {
        return;
      }
      Object localObject1 = new File(a(paramString, paramInt));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("troopGift_");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(".png");
      localObject2 = ((StringBuilder)localObject2).toString();
      SharedPreferences localSharedPreferences = this.e.getSharedPreferences(x, 0);
      long l1 = localSharedPreferences.getLong((String)localObject2, 0L);
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      int i;
      if ((l1 != 0L) && (l2 - l1 < 259200000L)) {
        i = 1;
      } else {
        i = 0;
      }
      boolean bool;
      if (this.A.get(localObject2) != null) {
        bool = ((Boolean)this.A.get(localObject2)).booleanValue();
      } else {
        bool = false;
      }
      if ((((File)localObject1).exists()) && (i != 0))
      {
        a(paramBubbleImageView, paramInt, paramString);
        return;
      }
      if (bool)
      {
        localObject1 = (ArrayList)this.B.get(localObject2);
        paramBitmap = (Bitmap)localObject1;
        if (localObject1 == null)
        {
          paramBitmap = new ArrayList();
          this.B.put(localObject2, paramBitmap);
        }
        paramBitmap.add(new TroopGiftMsgItemBuilder.2(this, paramBubbleImageView, paramString, paramInt));
        return;
      }
      this.A.put(localObject2, Boolean.valueOf(true));
      paramBubbleImageView.setImageDrawable(new ColorDrawable(paramInt));
      this.y.incrementAndGet();
      ThreadManager.post(new TroopGiftMsgItemBuilder.3(this, paramString, paramInt, paramBitmap, paramBubbleImageView, (String)localObject2, localSharedPreferences, l2), 8, null, false);
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, BaseChatItemLayout.l);
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.isSend();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    a(localQQCustomMenu, this.e, 2131444634, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    a(localQQCustomMenu, this.e, 2131444651, paramView, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopGift)paramChatMessage).title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */