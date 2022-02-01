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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ScoreQAVFragment.3(this);
  Button jdField_a_of_type_AndroidWidgetButton = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  RatingBar jdField_a_of_type_ComTencentAvWidgetRatingBar = null;
  private ScoreQAVFragment.QuestionAdapter jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$QuestionAdapter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString = "";
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<String> jdField_a_of_type_JavaUtilList;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  String jdField_b_of_type_JavaLangString;
  long jdField_c_of_type_Long;
  String jdField_c_of_type_JavaLangString;
  long jdField_d_of_type_Long;
  String jdField_d_of_type_JavaLangString;
  long jdField_e_of_type_Long = 1L;
  String jdField_e_of_type_JavaLangString = "";
  long jdField_f_of_type_Long;
  String jdField_f_of_type_JavaLangString = "";
  String g = "";
  
  void a()
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
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("enCodeString mReportProblems : ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("ScoreActivity", 2, localStringBuilder.toString());
    }
  }
  
  void a(int paramInt)
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376312));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getBaseActivity(), 2));
    this.jdField_a_of_type_ComTencentAvWidgetRatingBar = ((RatingBar)paramView.findViewById(2131375987));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
    try
    {
      if (ImageResUtil.a("qav_score_normal.jpg"))
      {
        ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
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
    this.jdField_a_of_type_ComTencentAvWidgetRatingBar.setOnRatingListener(new ScoreQAVFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364997));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374736));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378114));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramView != null) {
      this.jdField_d_of_type_JavaLangString = paramView.getCurrentAccountUin();
    }
    if (SharedPreUtils.e(this.jdField_d_of_type_JavaLangString).getBoolean(VideoConstants.l, false))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695841);
      this.jdField_a_of_type_ComTencentAvWidgetRatingBar.setClickable(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$QuestionAdapter = new ScoreQAVFragment.QuestionAdapter(this);
    paramView = new ScoreQAVFragment.2(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$QuestionAdapter.a(paramView);
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
          this.jdField_e_of_type_JavaLangString = paramString.getString("scoreProblemsVideo");
        }
        if (paramString.has("scoreProblemsAudio")) {
          this.jdField_f_of_type_JavaLangString = paramString.getString("scoreProblemsAudio");
        }
        if (!paramString.has("scoreProblemsNet")) {
          return;
        }
        this.g = paramString.getString("scoreProblemsNet");
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
  
  boolean a(int paramInt)
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
        if (!paramString.has(VideoConstants.k)) {
          return;
        }
        this.jdField_c_of_type_JavaLangString = paramString.getString(VideoConstants.k);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559760, paramViewGroup, false);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
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
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    a(paramView);
    new ScoreQAVFragment.ProcessDataTask(this).execute(new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment
 * JD-Core Version:    0.7.0.1
 */