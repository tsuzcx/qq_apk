package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class MemoryDayView
{
  public Context a;
  public String b;
  public String c;
  private LinearLayout d = null;
  private String e;
  private MemoryDayView.OnItemClick f = new MemoryDayView.1(this);
  private MemoryDayView.OnShareClick g = null;
  
  public MemoryDayView(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.e = paramString;
    this.d = new LinearLayout(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    this.d.setOrientation(1);
    this.d.setLayoutParams(paramContext);
    paramContext = FriendIntimateRelationshipConfProcessor.a();
    this.b = paramContext.P;
    this.c = paramContext.Q;
  }
  
  private int a(String paramString, float paramFloat, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 0;
    int i;
    if (!bool)
    {
      Paint localPaint = new Paint();
      localPaint.setTextSize(TypedValue.applyDimension(2, paramFloat, this.a.getResources().getDisplayMetrics()));
      i = (int)localPaint.measureText(paramString, 0, paramString.length());
    }
    else
    {
      i = 0;
    }
    paramString = (WindowManager)this.a.getSystemService("window");
    if (paramString != null) {
      j = paramString.getDefaultDisplay().getWidth();
    }
    return j - paramInt - i;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("intimate_relationship", 2, "jumph5Url strUrl Empty");
      return;
    }
    if ((!paramString.toLowerCase().startsWith("http://")) && (!paramString.toLowerCase().startsWith("https://")))
    {
      paramContext = new StringBuilder();
      paramContext.append("jumph5Url strUrl unRecognized ");
      paramContext.append(paramString);
      QLog.e("intimate_relationship", 2, paramContext.toString());
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    paramContext.startActivity(localIntent);
  }
  
  public LinearLayout a()
  {
    return this.d;
  }
  
  public void a(Context paramContext, ArrayList<IntimateInfo.MemoryDayInfo> paramArrayList)
  {
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      ((LinearLayout)localObject1).removeAllViews();
      localObject1 = new ArrayList();
      Object localObject2;
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        localObject2 = new Date(NetConnInfoCenter.getServerTimeMillis());
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          IntimateInfo.MemoryDayInfo localMemoryDayInfo = (IntimateInfo.MemoryDayInfo)paramArrayList.next();
          if ((localMemoryDayInfo != null) && (localMemoryDayInfo.date != 0L))
          {
            Date localDate = new Date(localMemoryDayInfo.date);
            if ((((Date)localObject2).getDay() == localDate.getDay()) && (((Date)localObject2).getMonth() == localDate.getMonth()) && (((Date)localObject2).getYear() == localDate.getYear())) {
              ((ArrayList)localObject1).add(localMemoryDayInfo);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        paramArrayList = this.d;
        int i = 0;
        paramArrayList.setVisibility(0);
        while (i < ((ArrayList)localObject1).size())
        {
          paramArrayList = (IntimateInfo.MemoryDayInfo)((ArrayList)localObject1).get(i);
          localObject2 = new MemoryDayView.MemoryDayItem(this, paramContext);
          ((MemoryDayView.MemoryDayItem)localObject2).a(paramArrayList);
          ((MemoryDayView.MemoryDayItem)localObject2).a(this.f);
          if (((MemoryDayView.MemoryDayItem)localObject2).a() != null) {
            this.d.addView(((MemoryDayView.MemoryDayItem)localObject2).a());
          }
          i += 1;
        }
      }
      this.d.setVisibility(8);
    }
  }
  
  public void a(MemoryDayView.OnShareClick paramOnShareClick)
  {
    this.g = paramOnShareClick;
  }
  
  public void b()
  {
    LinearLayout localLinearLayout = this.d;
    if (localLinearLayout != null) {
      localLinearLayout.removeAllViews();
    }
    this.d = null;
    this.f = null;
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.MemoryDayView
 * JD-Core Version:    0.7.0.1
 */