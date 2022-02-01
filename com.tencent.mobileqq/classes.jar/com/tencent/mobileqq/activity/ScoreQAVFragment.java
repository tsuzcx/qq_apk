package com.tencent.mobileqq.activity;

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
import com.tencent.av.AVLog;
import com.tencent.av.VideoConstants;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.widget.RatingBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "enCodeString mReportProblems : " + this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376821));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    this.jdField_a_of_type_ComTencentAvWidgetRatingBar = ((RatingBar)paramView.findViewById(2131376479));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
    try
    {
      if (ImageResUtil.a("qav_score_normal.jpg")) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), ImageResUtil.b() + "qav_score_normal.jpg"));
      }
      this.jdField_a_of_type_ComTencentAvWidgetRatingBar.setOnRatingListener(new ScoreQAVFragment.1(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365117));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#BBBBBB"));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375221));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378719));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      if (SharedPreUtils.e(this.jdField_d_of_type_JavaLangString).getBoolean(VideoConstants.l, false))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695827);
        this.jdField_a_of_type_ComTencentAvWidgetRatingBar.setClickable(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$QuestionAdapter = new ScoreQAVFragment.QuestionAdapter(this);
      paramView = new ScoreQAVFragment.2(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$QuestionAdapter.a(paramView);
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
  
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      AVLog.printColorLog("ScoreActivity", "parse config: " + paramString);
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
          AVLog.printColorLog("ScoreActivity", "parse exception: " + paramString.toString());
        } while (!QLog.isColorLevel());
        return;
      }
      AVLog.printColorLog("ScoreActivity", "parse|config is empty!");
    } while (!QLog.isColorLevel());
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
    if (!TextUtils.isEmpty(paramString)) {
      AVLog.printColorLog("ScoreActivity", "parse infos: " + paramString);
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
          AVLog.printColorLog("ScoreActivity", "parse exception: " + paramString.toString());
        } while (!QLog.isColorLevel());
        QLog.i("ScoreActivity", 2, "parse exception: " + paramString.toString());
        return;
      }
      AVLog.printColorLog("ScoreActivity", "parse|infos is empty!");
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131559885, paramViewGroup, false);
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
      new ScoreQAVFragment.ProcessDataTask(this).execute(new String[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment
 * JD-Core Version:    0.7.0.1
 */