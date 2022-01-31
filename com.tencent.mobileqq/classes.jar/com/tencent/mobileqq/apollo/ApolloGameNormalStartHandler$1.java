package com.tencent.mobileqq.apollo;

import aife;
import android.app.Activity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;

public class ApolloGameNormalStartHandler$1
  implements Runnable
{
  public ApolloGameNormalStartHandler$1(aife paramaife, int paramInt1, long paramLong, int paramInt2, int paramInt3, QQAppInterface paramQQAppInterface, String paramString1, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, Activity paramActivity) {}
  
  public void run()
  {
    CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(this.jdField_a_of_type_Int, true, "normalStart", this.jdField_a_of_type_Long, 7, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_b_of_type_JavaLangString);
    localStartCheckParam.extendJson = this.jdField_c_of_type_JavaLangString;
    localStartCheckParam.mTempAIOUin = this.jdField_d_of_type_JavaLangString;
    localStartCheckParam.mTempAIONickName = this.e;
    if ((this.jdField_d_of_type_Int == 318) || (this.jdField_d_of_type_Int == 319)) {
      localStartCheckParam.disableMinGame = true;
    }
    ApolloGameUtil.a(this.jdField_a_of_type_AndroidAppActivity, localStartCheckParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler.1
 * JD-Core Version:    0.7.0.1
 */