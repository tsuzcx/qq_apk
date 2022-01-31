package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import baig;
import baop;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ndn;
import pzs;
import qeg;
import qeh;
import qmu;
import qmv;

public class VideoFeedsOptView
  extends ImageView
{
  private static ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private int jdField_a_of_type_Int;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ApngDrawable jdField_a_of_type_ComTencentImageApngDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public VideoFeedsOptView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsOptView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(this.c)) {
      return null;
    }
    if (this.c.contains("?")) {
      return this.c + "&acttype=" + paramString + "&subpos=" + this.d;
    }
    return this.c + "?acttype=" + paramString + "&subpos=" + this.d;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
      jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(1);
    }
    jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new VideoFeedsOptView.3(paramString));
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    while (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() <= 0) {
      return false;
    }
    return true;
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString));
    if (a(getContext(), localIntent)) {
      getContext().startActivity(localIntent);
    }
  }
  
  private void c()
  {
    qmv localqmv = new qmv(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    localqmv.a(this.f).w(this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Boolean)
    {
      ndn.a(null, null, "0X800932F", "0X800932F", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", localqmv.a().a(), false);
      return;
    }
    ndn.a(null, null, "0X8009033", "0X8009033", 0, 0, String.valueOf(this.jdField_a_of_type_Int), "", "", localqmv.a().a(), false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.c = null;
    this.d = null;
    this.jdField_a_of_type_ComTencentImageApngDrawable = null;
    this.e = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.f = null;
    this.jdField_b_of_type_Boolean = false;
    setImageDrawable(null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentImageApngDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageApngDrawable.repaly();
      this.jdField_a_of_type_ComTencentImageApngDrawable.resume();
      c();
      a(a("2"));
    }
  }
  
  public void setActive(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setImageUrl(VideoInfo paramVideoInfo, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, pzs parampzs, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt6, int paramInt7)
  {
    if ((TextUtils.equals(paramString2, this.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(paramString3, this.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(paramString6, this.e))) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(paramString7));
        if (!parampzs.a.containsKey(paramString7)) {
          parampzs.a.put(paramString7, Integer.valueOf(0));
        }
      } while (((Integer)parampzs.a.get(paramString7)).intValue() >= paramInt6);
      if (!DateUtils.isToday(baig.b("ug_prefix_ug_1get3_opt_day_show_time")))
      {
        baig.a("ug_prefix_ug_1get3_opt_day_show_time", System.currentTimeMillis());
        baig.a("ug_prefix_ug_1get3_opt_day_click_" + paramString7, 0);
      }
    } while ((baig.a("ug_prefix_ug_1get3_opt_day_click_" + paramString7) >= paramInt7) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)));
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.c = paramString4;
    this.d = paramString5;
    this.e = paramString6;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.f = paramString1;
    this.jdField_b_of_type_Boolean = paramBoolean;
    paramVideoInfo = BaseApplicationImpl.getContext().getFilesDir() + "/shortvideo_opt_png/";
    paramString1 = new File(paramVideoInfo);
    if (!paramString1.exists()) {
      paramString1.mkdir();
    }
    paramString1 = paramString2.substring(paramString2.lastIndexOf("/") + 1, paramString2.lastIndexOf("."));
    paramString2 = new Bundle();
    paramString2.putInt("key_loop", 1);
    paramString2.putBoolean("key_use_auto_scale_params", false);
    paramString2.putBoolean("key_use_cache", false);
    paramString3 = new ColorDrawable(Color.parseColor("#00000000"));
    paramVideoInfo = baop.a(BaseApplicationImpl.sApplication.getRuntime(), paramVideoInfo + paramString1, this.jdField_a_of_type_JavaLangString, paramString3, new int[] { paramInt5 }, "-opt_png-", paramString2);
    if (paramVideoInfo != null)
    {
      if (paramVideoInfo.getStatus() == 2) {
        paramVideoInfo.restartDownload();
      }
      paramVideoInfo.setURLDrawableListener(new qeg(this, paramVideoInfo));
    }
    setOnClickListener(new qeh(this, parampzs, paramString7, paramInt4, paramInt3));
    setImageDrawable(paramVideoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsOptView
 * JD-Core Version:    0.7.0.1
 */