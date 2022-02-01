package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.VideoConstants;
import com.tencent.av.utils.ScoreManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

class ScoreQAVFragment$ProcessDataTask
  extends AsyncTask<String, Void, HashMap<Integer, Integer>>
{
  ScoreQAVFragment$ProcessDataTask(ScoreQAVFragment paramScoreQAVFragment) {}
  
  protected HashMap<Integer, Integer> a(String... paramVarArgs)
  {
    if ((this.a.jdField_d_of_type_JavaLangString != null) && (!this.a.jdField_d_of_type_JavaLangString.isEmpty()))
    {
      paramVarArgs = SharedPreUtils.e(this.a.jdField_d_of_type_JavaLangString);
      this.a.b = paramVarArgs.getString(VideoConstants.h, "");
      paramVarArgs = ScoreManager.a();
      this.a.b(paramVarArgs);
      paramVarArgs = QAVConfig.b(270).a;
      this.a.a(paramVarArgs);
      if (this.a.e.isEmpty())
      {
        paramVarArgs = this.a;
        paramVarArgs.e = paramVarArgs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131695844);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Video config data is invalid, use default!");
        }
      }
      if (this.a.f.isEmpty())
      {
        paramVarArgs = this.a;
        paramVarArgs.f = paramVarArgs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131695842);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Audio config data is invalid, use default!");
        }
      }
      if (this.a.g.isEmpty())
      {
        paramVarArgs = this.a;
        paramVarArgs.g = paramVarArgs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131695843);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Net config data is invalid, use default!");
        }
      }
      if (this.a.jdField_d_of_type_Long == 0L)
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.a.e);
        paramVarArgs.append("/");
        paramVarArgs.append(this.a.f);
        paramVarArgs.append("/");
        paramVarArgs.append(this.a.g);
        paramVarArgs = paramVarArgs.toString();
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.a.f);
        paramVarArgs.append("/");
        paramVarArgs.append(this.a.g);
        paramVarArgs = paramVarArgs.toString();
      }
      StringBuilder localStringBuilder;
      try
      {
        this.a.jdField_a_of_type_JavaUtilList = Arrays.asList(paramVarArgs.split("/"));
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse exception : ");
          localStringBuilder.append(paramVarArgs.getMessage());
          QLog.i("ScoreActivity", 2, localStringBuilder.toString());
        }
      }
      paramVarArgs = this.a.jdField_a_of_type_JavaUtilList;
      int i = 0;
      if ((paramVarArgs != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0)) {
        i = 0;
      }
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        try
        {
          paramVarArgs = ((String)this.a.jdField_a_of_type_JavaUtilList.get(i)).split(",");
          this.a.jdField_a_of_type_JavaUtilList.set(i, paramVarArgs[1]);
          int j = Integer.parseInt(paramVarArgs[0]);
          this.a.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(j));
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse exception : ");
            localStringBuilder.append(paramVarArgs.getMessage());
            QLog.i("ScoreActivity", 2, localStringBuilder.toString());
          }
        }
        i += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "processDataTask mDatas is invalid, use default!");
        }
        this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.a.jdField_a_of_type_JavaUtilList.add(HardCodeUtil.a(2131713501));
        this.a.jdField_a_of_type_JavaUtilList.add(HardCodeUtil.a(2131713494));
        this.a.jdField_a_of_type_JavaUtilList.add(HardCodeUtil.a(2131713497));
        this.a.jdField_a_of_type_JavaUtilList.add(HardCodeUtil.a(2131713500));
        this.a.jdField_a_of_type_JavaUtilList.add(HardCodeUtil.a(2131713495));
        this.a.jdField_a_of_type_JavaUtilList.add(HardCodeUtil.a(2131713499));
        this.a.jdField_a_of_type_JavaUtilList.add(HardCodeUtil.a(2131713496));
        this.a.jdField_a_of_type_JavaUtilList.add(HardCodeUtil.a(2131713498));
        while (i < this.a.jdField_a_of_type_JavaUtilList.size())
        {
          this.a.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(i));
          i += 1;
        }
      }
      return this.a.jdField_a_of_type_JavaUtilHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "mSelfUin is null!");
    }
    return null;
  }
  
  protected void a(HashMap<Integer, Integer> paramHashMap)
  {
    super.onPostExecute(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.ProcessDataTask
 * JD-Core Version:    0.7.0.1
 */