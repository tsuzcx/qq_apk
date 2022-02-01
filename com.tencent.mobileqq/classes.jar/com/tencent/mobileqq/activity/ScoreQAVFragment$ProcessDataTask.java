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
    if ((this.a.p != null) && (!this.a.p.isEmpty()))
    {
      paramVarArgs = SharedPreUtils.e(this.a.p);
      this.a.n = paramVarArgs.getString(VideoConstants.p, "");
      paramVarArgs = ScoreManager.a();
      this.a.b(paramVarArgs);
      paramVarArgs = QAVConfig.b(270).b;
      this.a.a(paramVarArgs);
      if (this.a.v.isEmpty())
      {
        paramVarArgs = this.a;
        paramVarArgs.v = paramVarArgs.q.getApplication().getString(2131893603);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Video config data is invalid, use default!");
        }
      }
      if (this.a.w.isEmpty())
      {
        paramVarArgs = this.a;
        paramVarArgs.w = paramVarArgs.q.getApplication().getString(2131893601);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Audio config data is invalid, use default!");
        }
      }
      if (this.a.x.isEmpty())
      {
        paramVarArgs = this.a;
        paramVarArgs.x = paramVarArgs.q.getApplication().getString(2131893602);
        if (QLog.isColorLevel()) {
          QLog.d("ScoreActivity", 2, "mProblem_Net config data is invalid, use default!");
        }
      }
      if (this.a.k == 0L)
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.a.v);
        paramVarArgs.append("/");
        paramVarArgs.append(this.a.w);
        paramVarArgs.append("/");
        paramVarArgs.append(this.a.x);
        paramVarArgs = paramVarArgs.toString();
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.a.w);
        paramVarArgs.append("/");
        paramVarArgs.append(this.a.x);
        paramVarArgs = paramVarArgs.toString();
      }
      StringBuilder localStringBuilder;
      try
      {
        this.a.a = Arrays.asList(paramVarArgs.split("/"));
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
      paramVarArgs = this.a.a;
      int i = 0;
      if ((paramVarArgs != null) && (this.a.a.size() > 0)) {
        i = 0;
      }
      while (i < this.a.a.size())
      {
        try
        {
          paramVarArgs = ((String)this.a.a.get(i)).split(",");
          this.a.a.set(i, paramVarArgs[1]);
          int j = Integer.parseInt(paramVarArgs[0]);
          this.a.u.put(Integer.valueOf(i), Integer.valueOf(j));
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
        this.a.a = new ArrayList();
        this.a.a.add(HardCodeUtil.a(2131911051));
        this.a.a.add(HardCodeUtil.a(2131911044));
        this.a.a.add(HardCodeUtil.a(2131911047));
        this.a.a.add(HardCodeUtil.a(2131911050));
        this.a.a.add(HardCodeUtil.a(2131911045));
        this.a.a.add(HardCodeUtil.a(2131911049));
        this.a.a.add(HardCodeUtil.a(2131911046));
        this.a.a.add(HardCodeUtil.a(2131911048));
        while (i < this.a.a.size())
        {
          this.a.u.put(Integer.valueOf(i), Integer.valueOf(i));
          i += 1;
        }
      }
      return this.a.u;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.ProcessDataTask
 * JD-Core Version:    0.7.0.1
 */