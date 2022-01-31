package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class RecentItemVoteData
  extends RecentUserBaseData
{
  public long b;
  
  public RecentItemVoteData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super.a(paramQQAppInterface, paramContext);
    if (AppSetting.b)
    {
      paramQQAppInterface = new StringBuilder(24);
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_c_of_type_Int != 0) {
        break label102;
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      return;
      label102:
      if (this.jdField_c_of_type_Int == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.jdField_c_of_type_Int == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.jdField_c_of_type_Int > 0) {
        paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读");
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_c_of_type_JavaLangString = TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemVoteData
 * JD-Core Version:    0.7.0.1
 */