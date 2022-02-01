package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoConstants;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.widget.RatingBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class ScoreQAVFragment
  extends PublicBaseFragment
{
  private ScoreQAVFragment.QuestionAdapter A;
  List<String> a;
  RatingBar b = null;
  Button c = null;
  TextView d = null;
  TextView e = null;
  String f = "";
  ImageView g;
  long h;
  long i;
  long j;
  long k;
  long l = 1L;
  int m;
  String n;
  String o;
  String p;
  QQAppInterface q;
  int r;
  long s;
  ArrayList<Integer> t = new ArrayList();
  HashMap<Integer, Integer> u = new HashMap();
  String v = "";
  String w = "";
  String x = "";
  View.OnClickListener y = new ScoreQAVFragment.3(this);
  private RecyclerView z;
  
  void a()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    int i1 = 0;
    while (i1 < this.t.size())
    {
      localStringBuilder.append(this.u.get(this.t.get(i1)));
      localStringBuilder.append(';');
      i1 += 1;
    }
    this.f = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("enCodeString mReportProblems : ");
      localStringBuilder.append(this.f);
      QLog.d("ScoreActivity", 2, localStringBuilder.toString());
    }
  }
  
  void a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.t.size())
    {
      if (((Integer)this.t.get(i1)).intValue() == paramInt) {
        this.t.remove(i1);
      }
      i1 += 1;
    }
  }
  
  void a(View paramView)
  {
    this.z = ((RecyclerView)paramView.findViewById(2131444523));
    this.z.setLayoutManager(new GridLayoutManager(getBaseActivity(), 2));
    this.b = ((RatingBar)paramView.findViewById(2131444173));
    this.g = ((ImageView)paramView.findViewById(2131435219));
    try
    {
      if (ImageResUtil.a("qav_score_normal.jpg"))
      {
        ImageView localImageView = this.g;
        localObject = getResources();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ImageResUtil.a());
        localStringBuilder.append("qav_score_normal.jpg");
        localImageView.setBackgroundDrawable(new BitmapDrawable((Resources)localObject, localStringBuilder.toString()));
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mIcon OOM: ");
        ((StringBuilder)localObject).append(localOutOfMemoryError);
        QLog.w("ScoreActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    this.b.setOnRatingListener(new ScoreQAVFragment.1(this));
    this.c = ((Button)paramView.findViewById(2131431129));
    this.c.setOnClickListener(this.y);
    this.c.setEnabled(false);
    this.c.setTextColor(Color.parseColor("#BBBBBB"));
    this.d = ((TextView)paramView.findViewById(2131442925));
    this.e = ((TextView)paramView.findViewById(2131446620));
    this.q = ((QQAppInterface)getBaseActivity().getAppRuntime());
    paramView = this.q;
    if (paramView != null) {
      this.p = paramView.getCurrentAccountUin();
    }
    if (SharedPreUtils.e(this.p).getBoolean(VideoConstants.t, false))
    {
      this.e.setText(2131893600);
      this.b.setClickable(false);
    }
    this.A = new ScoreQAVFragment.QuestionAdapter(this);
    paramView = new ScoreQAVFragment.2(this);
    this.A.a(paramView);
  }
  
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse config: ");
      localStringBuilder.append(paramString);
      AVLog.printColorLog("ScoreActivity", localStringBuilder.toString());
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("scoreProblemsVideo")) {
          this.v = paramString.getString("scoreProblemsVideo");
        }
        if (paramString.has("scoreProblemsAudio")) {
          this.w = paramString.getString("scoreProblemsAudio");
        }
        if (!paramString.has("scoreProblemsNet")) {
          return;
        }
        this.x = paramString.getString("scoreProblemsNet");
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse exception: ");
        localStringBuilder.append(paramString.toString());
        AVLog.printColorLog("ScoreActivity", localStringBuilder.toString());
        QLog.isColorLevel();
        return;
      }
    }
    else
    {
      AVLog.printColorLog("ScoreActivity", "parse|config is empty!");
      QLog.isColorLevel();
    }
  }
  
  void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse infos: ");
      localStringBuilder.append(paramString);
      AVLog.printColorLog("ScoreActivity", localStringBuilder.toString());
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has(VideoConstants.l)) {
          this.h = paramString.getLong(VideoConstants.l);
        }
        if (paramString.has(VideoConstants.m)) {
          this.i = paramString.getLong(VideoConstants.m);
        }
        if (paramString.has(VideoConstants.n)) {
          this.m = paramString.getInt(VideoConstants.n);
        }
        if (paramString.has(VideoConstants.r)) {
          this.k = paramString.getLong(VideoConstants.r);
        }
        if (paramString.has(VideoConstants.q)) {
          this.j = paramString.getLong(VideoConstants.q);
        }
        if (!paramString.has(VideoConstants.s)) {
          return;
        }
        this.o = paramString.getString(VideoConstants.s);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse exception: ");
        localStringBuilder.append(paramString.toString());
        AVLog.printColorLog("ScoreActivity", localStringBuilder.toString());
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse exception: ");
      localStringBuilder.append(paramString.toString());
      QLog.i("ScoreActivity", 2, localStringBuilder.toString());
    }
    else
    {
      AVLog.printColorLog("ScoreActivity", "parse|infos is empty!");
      if (QLog.isColorLevel()) {
        QLog.i("ScoreActivity", 2, "parse|infos is empty!");
      }
    }
  }
  
  boolean b(int paramInt)
  {
    int i1 = 0;
    boolean bool = false;
    while (i1 < this.t.size())
    {
      if (((Integer)this.t.get(i1)).intValue() == paramInt) {
        bool = true;
      }
      i1 += 1;
    }
    return bool;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625802, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    try
    {
      this.r = paramBundle.getInt("uinType", 0);
      this.s = paramBundle.getLong("uniseq", 0L);
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    a(paramView);
    new ScoreQAVFragment.ProcessDataTask(this).execute(new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment
 * JD-Core Version:    0.7.0.1
 */