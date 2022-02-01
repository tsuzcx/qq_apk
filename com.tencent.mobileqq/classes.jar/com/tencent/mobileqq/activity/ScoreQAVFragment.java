package com.tencent.mobileqq.activity;

import aflh;
import afli;
import aflj;
import afll;
import aflm;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import bhsi;
import com.tencent.av.VideoConstants;
import com.tencent.av.widget.RatingBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lbj;
import msq;
import org.json.JSONObject;

public class ScoreQAVFragment
  extends PublicBaseFragment
{
  public int a;
  public long a;
  private aflm jdField_a_of_type_Aflm;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aflj(this);
  public Button a;
  public ImageView a;
  public TextView a;
  RatingBar jdField_a_of_type_ComTencentAvWidgetRatingBar = null;
  public QQAppInterface a;
  public String a;
  public ArrayList<Integer> a;
  public HashMap<Integer, Integer> a;
  public List<String> a;
  public int b;
  public long b;
  public TextView b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public String g = "";
  
  public ScoreQAVFragment()
  {
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_e_of_type_Long = 1L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaUtilArrayList.get(i)));
      localStringBuilder.append(';');
      i += 1;
    }
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "enCodeString mReportProblems : " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue() == paramInt) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
      i += 1;
    }
  }
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376411));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    this.jdField_a_of_type_ComTencentAvWidgetRatingBar = ((RatingBar)paramView.findViewById(2131376084));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368212));
    try
    {
      if (msq.a("qav_score_normal.jpg")) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), msq.b() + "qav_score_normal.jpg"));
      }
      this.jdField_a_of_type_ComTencentAvWidgetRatingBar.setOnRatingListener(new aflh(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364867));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374839));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378235));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      if (bhsi.e(this.jdField_d_of_type_JavaLangString).getBoolean(VideoConstants.l, false))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695230);
        this.jdField_a_of_type_ComTencentAvWidgetRatingBar.setClickable(false);
      }
      this.jdField_a_of_type_Aflm = new aflm(this);
      paramView = new afli(this);
      this.jdField_a_of_type_Aflm.a(paramView);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ScoreActivity", 2, "mIcon OOM: " + localOutOfMemoryError);
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      lbj.c("ScoreActivity", "parse config: " + paramString);
    }
    do
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("scoreProblemsVideo")) {
          this.jdField_e_of_type_JavaLangString = paramString.getString("scoreProblemsVideo");
        }
        if (paramString.has("scoreProblemsAudio")) {
          this.jdField_f_of_type_JavaLangString = paramString.getString("scoreProblemsAudio");
        }
        if (paramString.has("scoreProblemsNet")) {
          this.g = paramString.getString("scoreProblemsNet");
        }
        return;
      }
      catch (Exception paramString)
      {
        do
        {
          paramString.printStackTrace();
          lbj.c("ScoreActivity", "parse exception: " + paramString.toString());
        } while (!QLog.isColorLevel());
        return;
      }
      lbj.c("ScoreActivity", "parse|config is empty!");
    } while (!QLog.isColorLevel());
  }
  
  public boolean a(int paramInt)
  {
    int i = 0;
    boolean bool = false;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).intValue() == paramInt) {
        bool = true;
      }
      i += 1;
    }
    return bool;
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      lbj.c("ScoreActivity", "parse infos: " + paramString);
    }
    do
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has(VideoConstants.jdField_d_of_type_JavaLangString)) {
          this.jdField_a_of_type_Long = paramString.getLong(VideoConstants.jdField_d_of_type_JavaLangString);
        }
        if (paramString.has(VideoConstants.jdField_e_of_type_JavaLangString)) {
          this.jdField_b_of_type_Long = paramString.getLong(VideoConstants.jdField_e_of_type_JavaLangString);
        }
        if (paramString.has(VideoConstants.jdField_f_of_type_JavaLangString)) {
          this.jdField_a_of_type_Int = paramString.getInt(VideoConstants.jdField_f_of_type_JavaLangString);
        }
        if (paramString.has(VideoConstants.j)) {
          this.jdField_d_of_type_Long = paramString.getLong(VideoConstants.j);
        }
        if (paramString.has(VideoConstants.i)) {
          this.jdField_c_of_type_Long = paramString.getLong(VideoConstants.i);
        }
        if (paramString.has(VideoConstants.k)) {
          this.jdField_c_of_type_JavaLangString = paramString.getString(VideoConstants.k);
        }
        return;
      }
      catch (Exception paramString)
      {
        do
        {
          paramString.printStackTrace();
          lbj.c("ScoreActivity", "parse exception: " + paramString.toString());
        } while (!QLog.isColorLevel());
        QLog.i("ScoreActivity", 2, "parse exception: " + paramString.toString());
        return;
      }
      lbj.c("ScoreActivity", "parse|infos is empty!");
    } while (!QLog.isColorLevel());
    QLog.i("ScoreActivity", 2, "parse|infos is empty!");
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559771, paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    try
    {
      this.jdField_b_of_type_Int = paramBundle.getInt("uinType", 0);
      this.jdField_f_of_type_Long = paramBundle.getLong("uniseq", 0L);
      a(paramView);
      new afll(this).execute(new String[0]);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment
 * JD-Core Version:    0.7.0.1
 */