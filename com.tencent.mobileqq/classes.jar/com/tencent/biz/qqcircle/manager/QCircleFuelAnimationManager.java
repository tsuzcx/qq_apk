package com.tencent.biz.qqcircle.manager;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.TaskCenterReader.TaskRecord;

public class QCircleFuelAnimationManager
{
  public static final String a = "QCircleFuelAnimationManager";
  private static volatile QCircleFuelAnimationManager b;
  private ConcurrentHashMap<String, Boolean> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> d = new ConcurrentHashMap();
  private Handler e;
  private boolean f = false;
  private boolean g = false;
  
  private ValueAnimator a(View paramView, PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4, long paramLong)
  {
    paramPointF1 = ValueAnimator.ofObject(new QCircleFuelAnimationManager.BezierEvaluator(this, paramPointF3, paramPointF4), new Object[] { paramPointF1, paramPointF2 });
    paramPointF1.setDuration(paramLong);
    paramPointF1.addUpdateListener(new QCircleFuelAnimationManager.4(this, paramView));
    return paramPointF1;
  }
  
  public static QCircleFuelAnimationManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QCircleFuelAnimationManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static URLDrawable a(String paramString, int[] paramArrayOfInt, Drawable paramDrawable, int paramInt)
  {
    QCircleFuelAnimationManager.3 local3 = new QCircleFuelAnimationManager.3(paramArrayOfInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", paramInt);
    return VasApngUtil.getApngURLDrawable(paramString, paramArrayOfInt, paramDrawable, localBundle, local3);
  }
  
  public void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, boolean paramBoolean)
  {
    if (c()) {
      if (paramImageView1 == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        this.e = new Handler();
        this.d.put(d(), Boolean.valueOf(true));
        this.c.put(d(), Boolean.valueOf(false));
        if (!this.f) {
          break label228;
        }
        localObject = "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/855/task_rocket/task_rocket_tooltips_5_000_iSpt.png";
        ApngImage.playByTag(33);
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#00000000"));
        localObject = a((String)localObject, new int[] { 33 }, localColorDrawable, 1);
        paramImageView1.setImageDrawable((Drawable)localObject);
        paramImageView1.setVisibility(0);
        if ((((URLDrawable)localObject).getCurrDrawable() instanceof ApngDrawable)) {
          ((ApngDrawable)((URLDrawable)localObject).getCurrDrawable()).getImage().reDraw();
        }
        this.e.postDelayed(new QCircleFuelAnimationManager.1(this, paramImageView1, paramImageView2, paramBoolean), 1800L);
        this.e.postDelayed(new QCircleFuelAnimationManager.2(this, paramView), 1800L);
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(40).setSubActionType(1).setThrActionType(0));
        return;
      }
      catch (Exception paramImageView1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, paramImageView1.getMessage());
        }
      }
      return;
      label228:
      Object localObject = "https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/855/task_rocket/task_rocket_tooltips_3_000_iSpt.png";
    }
  }
  
  public void a(ArrayList<TaskCenterReader.TaskRecord> paramArrayList)
  {
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        Object localObject1 = a;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("taskRecords.get(i).taskTyp:");
        ((StringBuilder)localObject2).append(((TaskCenterReader.TaskRecord)paramArrayList.get(i)).taskType.get());
        ((StringBuilder)localObject2).append("name:");
        ((StringBuilder)localObject2).append(((TaskCenterReader.TaskRecord)paramArrayList.get(i)).title.get());
        QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
        if ((((TaskCenterReader.TaskRecord)paramArrayList.get(i)).taskType.get() != 1) && (((TaskCenterReader.TaskRecord)paramArrayList.get(i)).taskType.get() != 6) && (((TaskCenterReader.TaskRecord)paramArrayList.get(i)).haveDone.get() > 0))
        {
          paramArrayList = new Date();
          localObject1 = new SimpleDateFormat("yyyy-MM-dd");
          localObject2 = this.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((SimpleDateFormat)localObject1).format(paramArrayList));
          localStringBuilder.append(HostDataTransUtils.getAccount());
          ((ConcurrentHashMap)localObject2).put(localStringBuilder.toString(), Boolean.valueOf(false));
          break;
        }
        i += 1;
      }
    }
    this.g = true;
    paramArrayList = new ColorDrawable(Color.parseColor("#00000000"));
    a("https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/855/task_rocket/task_rocket_tooltips_3_000_iSpt.png", new int[] { 33 }, paramArrayList, 1);
    paramArrayList = new ColorDrawable(Color.parseColor("#00000000"));
    a("https://wezone-theme.cdn-go.cn/url-resource/latest/defaultmode/855/task_rocket/task_rocket_tooltips_5_000_iSpt.png", new int[] { 33 }, paramArrayList, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d.put(d(), Boolean.valueOf(paramBoolean));
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public boolean c()
  {
    if (!this.g) {
      return false;
    }
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null)
    {
      if (localConcurrentHashMap.get(d()) == null)
      {
        this.c.put(d(), Boolean.valueOf(true));
        return true;
      }
      if (((Boolean)this.c.get(d())).booleanValue() == true) {
        return true;
      }
    }
    return false;
  }
  
  public String d()
  {
    Date localDate = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localSimpleDateFormat.format(localDate));
    localStringBuilder.append(HostDataTransUtils.getAccount());
    return localStringBuilder.toString();
  }
  
  public boolean e()
  {
    if (this.d.get(d()) != null) {
      return ((Boolean)this.d.get(d())).booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager
 * JD-Core Version:    0.7.0.1
 */