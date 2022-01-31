package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import axqy;
import bcql;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterItemView;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import vej;
import vfu;
import vfv;
import vfx;
import vhk;
import vhm;
import vix;
import vjy;
import vsa;
import vse;

@TargetApi(11)
public class EditVideoArtFilter
  extends vhk
  implements View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, Runnable
{
  public static final String a;
  public int a;
  long jdField_a_of_type_Long;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public ArtFilterItemView a;
  public HorizontalListView a;
  public AtomicInteger a;
  private vfv jdField_a_of_type_Vfv;
  private vfx jdField_a_of_type_Vfx;
  public boolean a;
  public int b;
  long jdField_b_of_type_Long = 0L;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public String c;
  public boolean c;
  int jdField_d_of_type_Int = 0;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = -1;
  String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean = true;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString = "";
  private int g = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = ArtFilterManager.jdField_a_of_type_JavaLangString + "artfiltertemp/";
  }
  
  public EditVideoArtFilter(@NonNull vhm paramvhm)
  {
    super(paramvhm);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
  }
  
  private Bitmap.Config a(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig = paramBitmap.getConfig();
    paramBitmap = localConfig;
    if (localConfig == null) {
      paramBitmap = Bitmap.Config.ARGB_8888;
    }
    return paramBitmap;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Vfv.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Vfv.notifyDataSetChanged();
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      }
    }
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
    } while (Build.VERSION.SDK_INT < 11);
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.getActivity();
    this.jdField_a_of_type_Vfv = new vfv(this, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    this.jdField_a_of_type_Vfx = new vfx(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView = ((ArtFilterItemView)a(2131362819));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131362812));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131362813));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131362820));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView != null) && (this.jdField_a_of_type_Vfv != null)) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.postDelayed(this, 10L);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.findViewById(2131362814));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.setHandler(this.jdField_a_of_type_Vfx, this.jdField_c_of_type_JavaLangString);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 666) && (paramInt2 == -1)) {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "editVideoState Change:" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a(this);
      }
      return;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Vfv.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.b();
    axqy.b(null, "dc00898", "", "", "0X800754F", "0X800754F", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, @NonNull vsa paramvsa)
  {
    if (b())
    {
      vse localvse = paramvsa.jdField_a_of_type_Vse;
      localvse.jdField_a_of_type_Int += 1;
      axqy.b(null, "dc00898", "", "", "0X8007551", "0X8007551", 0, 0, "", "", "", "");
      axqy.b(null, "dc00898", "", "", "0X8007552", "0X8007552", this.jdField_e_of_type_Int, 0, "", "", "", "");
      paramvsa.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("5");
      paramvsa.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reserves7 = (this.jdField_e_of_type_Int + "");
      vej.b("0X80075EF", vej.jdField_a_of_type_Int);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    vjy localvjy = this.jdField_a_of_type_Vfv.a(paramInt);
    if (localvjy == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "submitFilterTask:position:" + paramInt + "FilterTemplate" + localvjy);
    }
    a(paramInt);
    if ((this.jdField_d_of_type_JavaLangString.endsWith(".gif")) && (!paramBoolean))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690245), 0).a();
      return;
    }
    if (paramInt == 0)
    {
      a(null, -1);
      this.g = -1;
      return;
    }
    this.g = localvjy.jdField_a_of_type_Int;
    Object localObject = jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Long + "_" + localvjy.jdField_a_of_type_Int + ".png";
    if (new File((String)localObject).exists())
    {
      a((String)localObject, localvjy.jdField_a_of_type_Int);
      return;
    }
    paramInt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "submitFilterTask: timeStamp:" + this.jdField_a_of_type_Long + " currentTaskId:" + paramInt + " compressedFilePath:" + this.jdField_d_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a(paramInt);
    localObject = this.jdField_a_of_type_Vfx.obtainMessage(35);
    ((Message)localObject).obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_Vfx.sendMessageDelayed((Message)localObject, 20000L);
    b(true);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("param_art_filter_style_id", localvjy.jdField_a_of_type_Int);
    ((Bundle)localObject).putString("param_art_filter_style_name", localvjy.jdField_b_of_type_JavaLangString);
    ((Bundle)localObject).putLong("param_art_filter_file_name", this.jdField_a_of_type_Long);
    ((Bundle)localObject).putString("param_art_filter_resource_path", this.jdField_d_of_type_JavaLangString);
    ((Bundle)localObject).putInt("param_art_filter_task_id", paramInt);
    QIPCClientHelper.getInstance().callServer("ArtFilterModule", "action_get_art_filter_path", (Bundle)localObject, new vfu(this, localvjy));
  }
  
  /* Error */
  public void a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 8
    //   9: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +45 -> 57
    //   15: ldc 243
    //   17: iconst_2
    //   18: new 39	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 464
    //   28: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: getfield 466	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   35: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: ldc_w 387
    //   41: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_1
    //   58: invokevirtual 469	android/graphics/Bitmap:isRecycled	()Z
    //   61: ifeq +4 -> 65
    //   64: return
    //   65: aload_0
    //   66: getfield 466	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   69: ifnonnull +17 -> 86
    //   72: aload_0
    //   73: aload_1
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 471	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   79: iconst_1
    //   80: invokevirtual 475	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   83: putfield 466	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   86: aload_0
    //   87: getfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   90: invokestatic 481	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +20 -> 113
    //   96: new 372	java/io/File
    //   99: dup
    //   100: aload_0
    //   101: getfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   104: invokespecial 375	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 378	java/io/File:exists	()Z
    //   110: ifne -46 -> 64
    //   113: aload_0
    //   114: invokestatic 487	android/os/SystemClock:uptimeMillis	()J
    //   117: putfield 363	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Long	J
    //   120: new 39	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   127: getstatic 57	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   130: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_0
    //   134: getfield 363	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Long	J
    //   137: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   140: ldc_w 489
    //   143: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore 12
    //   151: aload_0
    //   152: getfield 466	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   155: invokevirtual 492	android/graphics/Bitmap:getHeight	()I
    //   158: istore_3
    //   159: aload_0
    //   160: getfield 466	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   163: invokevirtual 495	android/graphics/Bitmap:getWidth	()I
    //   166: istore 4
    //   168: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +40 -> 211
    //   174: ldc 243
    //   176: iconst_2
    //   177: new 39	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   184: ldc_w 497
    //   187: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_3
    //   191: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc_w 499
    //   197: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload 4
    //   202: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   211: iload_3
    //   212: iload 4
    //   214: invokestatic 505	java/lang/Math:max	(II)I
    //   217: istore 5
    //   219: iload 5
    //   221: aload_0
    //   222: getfield 506	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Int	I
    //   225: if_icmple +451 -> 676
    //   228: aload_0
    //   229: getfield 506	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Int	I
    //   232: i2f
    //   233: iload 5
    //   235: i2f
    //   236: fdiv
    //   237: fstore_2
    //   238: iload 4
    //   240: i2f
    //   241: fload_2
    //   242: fmul
    //   243: invokestatic 510	java/lang/Math:round	(F)I
    //   246: istore 4
    //   248: iload_3
    //   249: i2f
    //   250: fload_2
    //   251: fmul
    //   252: invokestatic 510	java/lang/Math:round	(F)I
    //   255: istore_3
    //   256: aload_1
    //   257: iload 4
    //   259: iload_3
    //   260: iconst_0
    //   261: invokestatic 514	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   264: astore 7
    //   266: aload 7
    //   268: astore 9
    //   270: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +44 -> 317
    //   276: ldc 243
    //   278: iconst_2
    //   279: new 39	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 516
    //   289: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload 4
    //   294: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: ldc_w 518
    //   300: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload_3
    //   304: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 7
    //   315: astore 9
    //   317: aload 9
    //   319: ifnull +722 -> 1041
    //   322: new 520	java/io/FileOutputStream
    //   325: dup
    //   326: new 372	java/io/File
    //   329: dup
    //   330: aload 12
    //   332: invokespecial 375	java/io/File:<init>	(Ljava/lang/String;)V
    //   335: invokespecial 523	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   338: astore 7
    //   340: new 525	java/io/BufferedOutputStream
    //   343: dup
    //   344: aload 7
    //   346: invokespecial 528	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   349: astore 8
    //   351: aload 9
    //   353: getstatic 534	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   356: bipush 90
    //   358: aload 8
    //   360: invokevirtual 538	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   363: istore 6
    //   365: aload 9
    //   367: invokevirtual 541	android/graphics/Bitmap:recycle	()V
    //   370: iload 6
    //   372: ifeq +49 -> 421
    //   375: aload_0
    //   376: aload 12
    //   378: putfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   381: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +32 -> 416
    //   387: ldc 243
    //   389: iconst_2
    //   390: new 39	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 543
    //   400: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: getfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   407: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload_0
    //   417: iconst_0
    //   418: putfield 77	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_Boolean	Z
    //   421: aload 7
    //   423: astore 10
    //   425: aload 8
    //   427: ifnull +8 -> 435
    //   430: aload 8
    //   432: invokevirtual 546	java/io/BufferedOutputStream:close	()V
    //   435: aload 10
    //   437: astore 9
    //   439: aload 8
    //   441: astore 7
    //   443: aload 10
    //   445: ifnull +16 -> 461
    //   448: aload 10
    //   450: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   453: aload 8
    //   455: astore 7
    //   457: aload 10
    //   459: astore 9
    //   461: aload_0
    //   462: getfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   465: ifnonnull -401 -> 64
    //   468: new 520	java/io/FileOutputStream
    //   471: dup
    //   472: new 372	java/io/File
    //   475: dup
    //   476: aload 12
    //   478: invokespecial 375	java/io/File:<init>	(Ljava/lang/String;)V
    //   481: invokespecial 523	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   484: astore 8
    //   486: new 525	java/io/BufferedOutputStream
    //   489: dup
    //   490: aload 8
    //   492: invokespecial 528	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   495: astore 9
    //   497: aload_1
    //   498: getstatic 534	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   501: bipush 90
    //   503: aload 9
    //   505: invokevirtual 538	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   508: ifeq +49 -> 557
    //   511: aload_0
    //   512: aload 12
    //   514: putfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   517: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +32 -> 552
    //   523: ldc 243
    //   525: iconst_2
    //   526: new 39	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 549
    //   536: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload_0
    //   540: getfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   543: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: aload_0
    //   553: iconst_0
    //   554: putfield 77	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_Boolean	Z
    //   557: aload 9
    //   559: ifnull +8 -> 567
    //   562: aload 9
    //   564: invokevirtual 546	java/io/BufferedOutputStream:close	()V
    //   567: aload 8
    //   569: ifnull +8 -> 577
    //   572: aload 8
    //   574: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   577: aload_0
    //   578: getfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   581: ifnonnull -517 -> 64
    //   584: aload_0
    //   585: aload_0
    //   586: getfield 177	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   589: putfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   592: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq +32 -> 627
    //   598: ldc 243
    //   600: iconst_2
    //   601: new 39	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   608: ldc_w 551
    //   611: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_0
    //   615: getfield 327	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   618: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: aload_0
    //   628: iconst_1
    //   629: putfield 77	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_d_of_type_Boolean	Z
    //   632: return
    //   633: astore_1
    //   634: aload_1
    //   635: invokevirtual 554	java/lang/OutOfMemoryError:printStackTrace	()V
    //   638: return
    //   639: astore 7
    //   641: aload 7
    //   643: invokevirtual 554	java/lang/OutOfMemoryError:printStackTrace	()V
    //   646: iconst_0
    //   647: ifeq +11 -> 658
    //   650: new 556	java/lang/NullPointerException
    //   653: dup
    //   654: invokespecial 557	java/lang/NullPointerException:<init>	()V
    //   657: athrow
    //   658: iconst_0
    //   659: ifeq -595 -> 64
    //   662: new 556	java/lang/NullPointerException
    //   665: dup
    //   666: invokespecial 557	java/lang/NullPointerException:<init>	()V
    //   669: athrow
    //   670: astore_1
    //   671: aload_1
    //   672: invokevirtual 558	java/io/IOException:printStackTrace	()V
    //   675: return
    //   676: aload_1
    //   677: aload_0
    //   678: aload_1
    //   679: invokespecial 471	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;
    //   682: iconst_1
    //   683: invokevirtual 475	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   686: astore 9
    //   688: goto -371 -> 317
    //   691: astore 7
    //   693: aload 7
    //   695: invokevirtual 554	java/lang/OutOfMemoryError:printStackTrace	()V
    //   698: iconst_0
    //   699: ifeq +11 -> 710
    //   702: new 556	java/lang/NullPointerException
    //   705: dup
    //   706: invokespecial 557	java/lang/NullPointerException:<init>	()V
    //   709: athrow
    //   710: iconst_0
    //   711: ifeq -647 -> 64
    //   714: new 556	java/lang/NullPointerException
    //   717: dup
    //   718: invokespecial 557	java/lang/NullPointerException:<init>	()V
    //   721: athrow
    //   722: astore_1
    //   723: aload_1
    //   724: invokevirtual 558	java/io/IOException:printStackTrace	()V
    //   727: return
    //   728: astore 7
    //   730: aload 7
    //   732: invokevirtual 558	java/io/IOException:printStackTrace	()V
    //   735: aload 10
    //   737: astore 9
    //   739: aload 8
    //   741: astore 7
    //   743: goto -282 -> 461
    //   746: astore 7
    //   748: aconst_null
    //   749: astore 8
    //   751: aload 7
    //   753: invokevirtual 559	java/lang/Exception:printStackTrace	()V
    //   756: aload 10
    //   758: ifnull +8 -> 766
    //   761: aload 10
    //   763: invokevirtual 546	java/io/BufferedOutputStream:close	()V
    //   766: aload 8
    //   768: astore 9
    //   770: aload 10
    //   772: astore 7
    //   774: aload 8
    //   776: ifnull -315 -> 461
    //   779: aload 8
    //   781: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   784: aload 8
    //   786: astore 9
    //   788: aload 10
    //   790: astore 7
    //   792: goto -331 -> 461
    //   795: astore 7
    //   797: aload 7
    //   799: invokevirtual 558	java/io/IOException:printStackTrace	()V
    //   802: aload 8
    //   804: astore 9
    //   806: aload 10
    //   808: astore 7
    //   810: goto -349 -> 461
    //   813: astore_1
    //   814: aconst_null
    //   815: astore 8
    //   817: aload 11
    //   819: astore 7
    //   821: aload 8
    //   823: ifnull +8 -> 831
    //   826: aload 8
    //   828: invokevirtual 546	java/io/BufferedOutputStream:close	()V
    //   831: aload 7
    //   833: ifnull +8 -> 841
    //   836: aload 7
    //   838: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   841: aload_1
    //   842: athrow
    //   843: astore 7
    //   845: aload 7
    //   847: invokevirtual 558	java/io/IOException:printStackTrace	()V
    //   850: goto -9 -> 841
    //   853: astore_1
    //   854: aload_1
    //   855: invokevirtual 558	java/io/IOException:printStackTrace	()V
    //   858: goto -281 -> 577
    //   861: astore 8
    //   863: aload 9
    //   865: astore_1
    //   866: aload 8
    //   868: invokevirtual 559	java/lang/Exception:printStackTrace	()V
    //   871: aload 7
    //   873: ifnull +8 -> 881
    //   876: aload 7
    //   878: invokevirtual 546	java/io/BufferedOutputStream:close	()V
    //   881: aload_1
    //   882: ifnull -305 -> 577
    //   885: aload_1
    //   886: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   889: goto -312 -> 577
    //   892: astore_1
    //   893: aload_1
    //   894: invokevirtual 558	java/io/IOException:printStackTrace	()V
    //   897: goto -320 -> 577
    //   900: astore_1
    //   901: aload 9
    //   903: astore 8
    //   905: aload 7
    //   907: ifnull +8 -> 915
    //   910: aload 7
    //   912: invokevirtual 546	java/io/BufferedOutputStream:close	()V
    //   915: aload 8
    //   917: ifnull +8 -> 925
    //   920: aload 8
    //   922: invokevirtual 547	java/io/FileOutputStream:close	()V
    //   925: aload_1
    //   926: athrow
    //   927: astore 7
    //   929: aload 7
    //   931: invokevirtual 558	java/io/IOException:printStackTrace	()V
    //   934: goto -9 -> 925
    //   937: astore_1
    //   938: goto -33 -> 905
    //   941: astore_1
    //   942: aload 9
    //   944: astore 7
    //   946: goto -41 -> 905
    //   949: astore 9
    //   951: aload_1
    //   952: astore 8
    //   954: aload 9
    //   956: astore_1
    //   957: goto -52 -> 905
    //   960: astore 9
    //   962: aload 8
    //   964: astore_1
    //   965: aload 9
    //   967: astore 8
    //   969: goto -103 -> 866
    //   972: astore 10
    //   974: aload 8
    //   976: astore_1
    //   977: aload 9
    //   979: astore 7
    //   981: aload 10
    //   983: astore 8
    //   985: goto -119 -> 866
    //   988: astore_1
    //   989: aconst_null
    //   990: astore 8
    //   992: goto -171 -> 821
    //   995: astore_1
    //   996: goto -175 -> 821
    //   999: astore_1
    //   1000: aload 8
    //   1002: astore 7
    //   1004: aload 10
    //   1006: astore 8
    //   1008: goto -187 -> 821
    //   1011: astore 9
    //   1013: aload 7
    //   1015: astore 8
    //   1017: aload 9
    //   1019: astore 7
    //   1021: goto -270 -> 751
    //   1024: astore 9
    //   1026: aload 8
    //   1028: astore 10
    //   1030: aload 7
    //   1032: astore 8
    //   1034: aload 9
    //   1036: astore 7
    //   1038: goto -287 -> 751
    //   1041: aconst_null
    //   1042: astore 10
    //   1044: goto -619 -> 425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1047	0	this	EditVideoArtFilter
    //   0	1047	1	paramBitmap	Bitmap
    //   237	14	2	f1	float
    //   158	146	3	i	int
    //   166	127	4	j	int
    //   217	17	5	k	int
    //   363	8	6	bool	boolean
    //   264	192	7	localObject1	Object
    //   639	3	7	localOutOfMemoryError1	OutOfMemoryError
    //   691	3	7	localOutOfMemoryError2	OutOfMemoryError
    //   728	3	7	localIOException1	java.io.IOException
    //   741	1	7	localObject2	Object
    //   746	6	7	localException1	java.lang.Exception
    //   772	19	7	localObject3	Object
    //   795	3	7	localIOException2	java.io.IOException
    //   808	29	7	localObject4	Object
    //   843	68	7	localIOException3	java.io.IOException
    //   927	3	7	localIOException4	java.io.IOException
    //   944	93	7	localObject5	Object
    //   7	820	8	localObject6	Object
    //   861	6	8	localException2	java.lang.Exception
    //   903	130	8	localObject7	Object
    //   268	675	9	localObject8	Object
    //   949	6	9	localObject9	Object
    //   960	18	9	localException3	java.lang.Exception
    //   1011	7	9	localException4	java.lang.Exception
    //   1024	11	9	localException5	java.lang.Exception
    //   1	806	10	localObject10	Object
    //   972	33	10	localException6	java.lang.Exception
    //   1028	15	10	localObject11	Object
    //   4	814	11	localObject12	Object
    //   149	364	12	str	String
    // Exception table:
    //   from	to	target	type
    //   72	86	633	java/lang/OutOfMemoryError
    //   256	266	639	java/lang/OutOfMemoryError
    //   650	658	670	java/io/IOException
    //   662	670	670	java/io/IOException
    //   676	688	691	java/lang/OutOfMemoryError
    //   702	710	722	java/io/IOException
    //   714	722	722	java/io/IOException
    //   430	435	728	java/io/IOException
    //   448	453	728	java/io/IOException
    //   151	211	746	java/lang/Exception
    //   211	256	746	java/lang/Exception
    //   256	266	746	java/lang/Exception
    //   270	313	746	java/lang/Exception
    //   322	340	746	java/lang/Exception
    //   641	646	746	java/lang/Exception
    //   676	688	746	java/lang/Exception
    //   693	698	746	java/lang/Exception
    //   761	766	795	java/io/IOException
    //   779	784	795	java/io/IOException
    //   151	211	813	finally
    //   211	256	813	finally
    //   256	266	813	finally
    //   270	313	813	finally
    //   322	340	813	finally
    //   641	646	813	finally
    //   676	688	813	finally
    //   693	698	813	finally
    //   826	831	843	java/io/IOException
    //   836	841	843	java/io/IOException
    //   562	567	853	java/io/IOException
    //   572	577	853	java/io/IOException
    //   468	486	861	java/lang/Exception
    //   876	881	892	java/io/IOException
    //   885	889	892	java/io/IOException
    //   468	486	900	finally
    //   910	915	927	java/io/IOException
    //   920	925	927	java/io/IOException
    //   486	497	937	finally
    //   497	552	941	finally
    //   552	557	941	finally
    //   866	871	949	finally
    //   486	497	960	java/lang/Exception
    //   497	552	972	java/lang/Exception
    //   552	557	972	java/lang/Exception
    //   340	351	988	finally
    //   351	370	995	finally
    //   375	416	995	finally
    //   416	421	995	finally
    //   751	756	999	finally
    //   340	351	1011	java/lang/Exception
    //   351	370	1024	java/lang/Exception
    //   375	416	1024	java/lang/Exception
    //   416	421	1024	java/lang/Exception
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject1;
    for (;;)
    {
      Bitmap localBitmap;
      Object localObject2;
      label323:
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "before LoadUp: lastFilePath:" + this.jdField_f_of_type_JavaLangString + " lastOriginalBitmap:" + this.jdField_e_of_type_Boolean + " fileOutputPath:" + paramString);
        }
        if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
          break label407;
        }
        this.jdField_f_of_type_Int = this.jdField_d_of_type_Int;
        boolean bool = paramString.equals(this.jdField_f_of_type_JavaLangString);
        if (bool) {
          return;
        }
        localObject1 = null;
      }
      finally {}
      try
      {
        localBitmap = BitmapFactory.decodeFile(paramString);
        localObject2 = localBitmap;
        localObject1 = localBitmap;
        if (this.jdField_d_of_type_Boolean)
        {
          localObject2 = localBitmap;
          localObject1 = localBitmap;
          if (this.jdField_b_of_type_Int != 0)
          {
            localObject2 = localBitmap;
            localObject1 = localBitmap;
            if (this.jdField_b_of_type_Int % 90 == 0)
            {
              localObject1 = localBitmap;
              if (QLog.isColorLevel())
              {
                localObject1 = localBitmap;
                QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "load bitmap has exif rotate " + this.jdField_b_of_type_Int);
              }
              localObject1 = localBitmap;
              int i = localBitmap.getWidth();
              localObject1 = localBitmap;
              int j = localBitmap.getHeight();
              localObject1 = localBitmap;
              localObject2 = new Matrix();
              localObject1 = localBitmap;
              ((Matrix)localObject2).postRotate(this.jdField_b_of_type_Int, i / 2.0F, j / 2.0F);
              localObject1 = localBitmap;
              localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, i, j, (Matrix)localObject2, true);
              localObject1 = localBitmap;
              localBitmap.recycle();
            }
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("Q.qqstory.publish.edit.EditVideoArtFilter", 1, "load oom");
        Object localObject3 = localObject1;
        continue;
      }
      if (localObject2 != null)
      {
        this.jdField_a_of_type_Vhm.a((Bitmap)localObject2, true);
        this.jdField_f_of_type_JavaLangString = paramString;
        this.jdField_e_of_type_Int = paramInt;
        this.jdField_e_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          break label461;
        }
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "before LoadUp: lastFilePath:" + this.jdField_f_of_type_JavaLangString + " lastOriginalBitmap:" + this.jdField_e_of_type_Boolean + " fileOutputPath:" + paramString);
      }
    }
    label407:
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      if (!this.jdField_e_of_type_Boolean)
      {
        localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap.copy(a(this.jdField_a_of_type_AndroidGraphicsBitmap), true);
        this.jdField_a_of_type_Vhm.a((Bitmap)localObject1, true);
      }
    }
    for (;;)
    {
      this.jdField_f_of_type_JavaLangString = "";
      this.jdField_e_of_type_Boolean = true;
      break label323;
      label461:
      break;
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Vhm.a().copy(a(this.jdField_a_of_type_Vhm.a()), true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "initState:isProcessing:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      f();
      if (paramBoolean) {
        a(this.jdField_f_of_type_Int);
      }
    }
    this.g = -1;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Vhm.jdField_b_of_type_Int == 12)
    {
      if (a(this.jdField_c_of_type_Int))
      {
        a(false);
        a(this.jdField_c_of_type_Int, true);
        this.jdField_a_of_type_Vhm.a(0);
      }
      return true;
    }
    return false;
  }
  
  boolean a(int paramInt)
  {
    if (this.jdField_d_of_type_JavaLangString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "compressedFilePath has not generated");
      }
    }
    do
    {
      long l;
      do
      {
        return false;
        l = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "mLastItemClickTime:" + this.jdField_b_of_type_Long + " mLastItemClickPosition:" + this.jdField_d_of_type_Int + " ClickTime:" + l + " ClickPosition:" + paramInt);
        }
      } while (l - this.jdField_b_of_type_Long < 300L);
      this.jdField_b_of_type_Long = l;
    } while ((this.jdField_d_of_type_Int == paramInt) && (this.jdField_a_of_type_Boolean));
    this.jdField_d_of_type_Int = paramInt;
    if (this.jdField_d_of_type_Int != 0) {
      axqy.b(null, "dc00898", "", "", "0X8007550", "0X8007550", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_Boolean) || (!this.jdField_e_of_type_Boolean);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    this.jdField_a_of_type_Vfx.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Vfx = null;
    if (this.jdField_c_of_type_Boolean) {
      QIPCClientHelper.getInstance().callServer("ArtFilterModule", "action_exit_art_filter", null, null);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterItemView.a();
    this.jdField_a_of_type_Vfx.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "CancelFilterTaskId:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    b(false);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoArtFilter", 2, "updateCropImg");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_e_of_type_Boolean = true;
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      this.jdField_d_of_type_JavaLangString = null;
    }
    a(0);
    this.jdField_f_of_type_Int = 0;
    if (b()) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131362812: 
      do
      {
        return;
      } while (!a(this.jdField_c_of_type_Int));
      if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 5, 2);
      }
      a(false);
      a(this.jdField_c_of_type_Int, true);
      this.jdField_a_of_type_Vhm.a(0);
      return;
    }
    if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.allReport(615, 5, 3);
    }
    this.jdField_a_of_type_Vhm.a(0);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (a(paramInt))
    {
      if ((this.jdField_a_of_type_Vhm != null) && (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 3)) {
        LpReportInfo_pf00064.allReport(615, 5, 4);
      }
      a(false);
      a(paramInt, false);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (paramView.getId() == 2131362814))
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      onClick(this.jdField_b_of_type_AndroidWidgetTextView);
      return true;
    }
    return false;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 674	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   4: invokestatic 481	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +235 -> 242
    //   10: new 297	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 675	java/util/ArrayList:<init>	()V
    //   17: astore_2
    //   18: new 677	org/json/JSONArray
    //   21: dup
    //   22: aload_0
    //   23: getfield 674	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokespecial 678	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: aload_3
    //   34: invokevirtual 681	org/json/JSONArray:length	()I
    //   37: if_icmpge +71 -> 108
    //   40: aload_3
    //   41: iload_1
    //   42: invokevirtual 685	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   45: astore 4
    //   47: aload_2
    //   48: new 360	vjy
    //   51: dup
    //   52: aload 4
    //   54: ldc_w 687
    //   57: invokevirtual 693	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   60: aload 4
    //   62: ldc_w 695
    //   65: invokevirtual 698	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   68: aload 4
    //   70: ldc_w 700
    //   73: invokevirtual 693	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   76: aload 4
    //   78: ldc_w 702
    //   81: invokevirtual 698	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: aload 4
    //   86: ldc_w 704
    //   89: invokevirtual 698	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokespecial 707	vjy:<init>	(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   95: invokeinterface 710 2 0
    //   100: pop
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -73 -> 32
    //   108: aload_2
    //   109: invokeinterface 714 1 0
    //   114: astore_3
    //   115: aload_3
    //   116: invokeinterface 719 1 0
    //   121: ifeq +130 -> 251
    //   124: new 372	java/io/File
    //   127: dup
    //   128: aload_3
    //   129: invokeinterface 723 1 0
    //   134: checkcast 360	vjy
    //   137: getfield 724	vjy:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   140: invokespecial 375	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore 4
    //   145: aload 4
    //   147: invokevirtual 378	java/io/File:exists	()Z
    //   150: ifeq +11 -> 161
    //   153: aload 4
    //   155: invokevirtual 727	java/io/File:isFile	()Z
    //   158: ifne -43 -> 115
    //   161: aload_3
    //   162: invokeinterface 730 1 0
    //   167: goto -52 -> 115
    //   170: astore_3
    //   171: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +12 -> 186
    //   177: ldc 243
    //   179: iconst_2
    //   180: ldc_w 732
    //   183: invokestatic 599	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +34 -> 223
    //   192: ldc 243
    //   194: iconst_2
    //   195: new 39	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 734
    //   205: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_2
    //   209: invokeinterface 737 1 0
    //   214: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: getfield 113	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Vfv	Lvfv;
    //   227: aload_2
    //   228: invokevirtual 740	vfv:a	(Ljava/util/List;)V
    //   231: aload_0
    //   232: getfield 206	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentWidgetHorizontalListView	Lcom/tencent/widget/HorizontalListView;
    //   235: aload_0
    //   236: getfield 113	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Vfv	Lvfv;
    //   239: invokevirtual 744	com/tencent/widget/HorizontalListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   242: aload_0
    //   243: getfield 206	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_ComTencentWidgetHorizontalListView	Lcom/tencent/widget/HorizontalListView;
    //   246: aload_0
    //   247: invokevirtual 210	com/tencent/widget/HorizontalListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   250: return
    //   251: aload_2
    //   252: invokestatic 749	java/util/Collections:sort	(Ljava/util/List;)V
    //   255: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +34 -> 292
    //   261: ldc 243
    //   263: iconst_2
    //   264: new 39	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 734
    //   274: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_2
    //   278: invokeinterface 737 1 0
    //   283: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   286: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aload_0
    //   293: getfield 113	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Vfv	Lvfv;
    //   296: aload_2
    //   297: invokevirtual 740	vfv:a	(Ljava/util/List;)V
    //   300: goto -69 -> 231
    //   303: astore_3
    //   304: invokestatic 241	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +34 -> 341
    //   310: ldc 243
    //   312: iconst_2
    //   313: new 39	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 734
    //   323: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokeinterface 737 1 0
    //   332: invokevirtual 248	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 251	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_0
    //   342: getfield 113	com/tencent/biz/qqstory/takevideo/EditVideoArtFilter:jdField_a_of_type_Vfv	Lvfv;
    //   345: aload_2
    //   346: invokevirtual 740	vfv:a	(Ljava/util/List;)V
    //   349: aload_3
    //   350: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	EditVideoArtFilter
    //   31	74	1	i	int
    //   17	329	2	localArrayList	ArrayList
    //   29	133	3	localObject1	Object
    //   170	1	3	localJSONException	org.json.JSONException
    //   303	47	3	localObject2	Object
    //   45	109	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	30	170	org/json/JSONException
    //   32	101	170	org/json/JSONException
    //   108	115	170	org/json/JSONException
    //   115	161	170	org/json/JSONException
    //   161	167	170	org/json/JSONException
    //   251	255	170	org/json/JSONException
    //   18	30	303	finally
    //   32	101	303	finally
    //   108	115	303	finally
    //   115	161	303	finally
    //   161	167	303	finally
    //   171	186	303	finally
    //   251	255	303	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoArtFilter
 * JD-Core Version:    0.7.0.1
 */