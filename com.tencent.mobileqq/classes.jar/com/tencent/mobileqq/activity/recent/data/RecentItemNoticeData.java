package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.Locale;

public class RecentItemNoticeData
  extends RecentUserBaseData
{
  public Intent a;
  public String a;
  public long b;
  public long c;
  public String g;
  public String h;
  public int j;
  
  public RecentItemNoticeData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(int paramInt, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2)
  {
    this.j = paramInt;
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.g = paramString2;
    this.h = paramString3;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_b_of_type_JavaLangString = String.format(Locale.getDefault(), "%s:%s", new Object[] { paramString3, paramString1 });
    this.jdField_c_of_type_JavaLangString = TimeFormatterUtils.a(paramLong2, true, "yyyy-MM-dd");
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
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
  
  public boolean a(int paramInt, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2)
  {
    if (this.j != paramInt) {}
    while ((this.jdField_b_of_type_Long != paramLong1) || (this.jdField_c_of_type_Long != paramLong2) || (!Utils.a(this.jdField_a_of_type_JavaLangString, paramString1)) || (!Utils.a(this.g, paramString2)) || (!Utils.a(this.h, paramString3))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData
 * JD-Core Version:    0.7.0.1
 */