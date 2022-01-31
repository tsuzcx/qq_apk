package com.tencent.av.ui.redbag;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GameSink
  extends SubHandleBase
{
  public ResultData a;
  
  GameSink(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    AVRedBagMgr localAVRedBagMgr = a();
    if (localAVRedBagMgr == null) {
      return;
    }
    ResultData localResultData = this.jdField_a_of_type_ComTencentAvUiRedbagResultData;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData = new ResultData(paramString1, paramString2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    QLog.w("AVRedBag_GameSink", 1, "onGameStart, new[" + this.jdField_a_of_type_ComTencentAvUiRedbagResultData + "], last[" + localResultData + "], fromType[" + paramInt + "], isAVActivityVisible[" + localAVRedBagMgr.e() + "], isSelfVideoOpen[" + RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface) + "]");
    if (!this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean)
    {
      if (!localAVRedBagMgr.e()) {
        RedBagReport.a();
      }
      if (!RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        RedBagReport.b();
      }
    }
    RedBagReport.a(paramInt);
    localAVRedBagMgr.a(this);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString5, String paramString6, String paramString7, boolean paramBoolean, int paramInt5)
  {
    AVRedBagMgr localAVRedBagMgr = a();
    if (localAVRedBagMgr == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData == null)
    {
      this.jdField_a_of_type_ComTencentAvUiRedbagResultData = new ResultData(paramString1, paramString2, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      QLog.w("AVRedBag_GameSink", 1, "onGameEnd , mResultData is empty");
    }
    String str1 = this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean = TextUtils.equals(paramString1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.i = paramString5;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_f_of_type_JavaLangString = paramString7;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_JavaLangString = paramString6;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_f_of_type_Int = paramInt5;
    if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_Int = GetRedBag.a(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.i, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_f_of_type_JavaLangString);
    }
    if ((!this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean) && (paramBoolean)) {
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), "avRedPacketFinGameSuc", true, 0L, 0L, null, "");
    }
    paramString1 = new StringBuilder().append("onGameEnd, startUin[").append(str1).append("->").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_JavaLangString).append("], playUin[").append(str2).append("->").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_JavaLangString).append("], mStarter[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean).append("], score[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Int).append("/").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Int).append("], Emoji[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_c_of_type_Int).append("/").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_d_of_type_Int).append("], money[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.i).append("], playerGetRedbagResultCode[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_JavaLangString).append("], playerGetRedbagResultState[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_f_of_type_JavaLangString).append("], isSucc[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Boolean).append("], exceptionType[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_f_of_type_Int).append("], mRedbagErrorType[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_e_of_type_Int).append("], mRedbagId[").append(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_c_of_type_JavaLangString).append("], mAuthKey[");
    if (paramString4 == null) {}
    for (paramInt1 = 0;; paramInt1 = paramString4.length())
    {
      QLog.w("AVRedBag_GameSink", 1, paramInt1 + "]");
      localAVRedBagMgr.b(this.jdField_a_of_type_ComTencentAvUiRedbagResultData);
      if ((this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_f_of_type_Int == 0)) {
        RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_JavaLangString, 0, "你刚发送的视频电话红包对方没有领取，将在24小时后退回。");
      }
      if (this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_b_of_type_Boolean) {
        RedBagReport.a(this.jdField_a_of_type_ComTencentAvUiRedbagResultData.jdField_c_of_type_JavaLangString);
      }
      GuideTip2.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvUiRedbagResultData = null;
      return;
    }
  }
  
  public String toString()
  {
    return "mResultData[" + this.jdField_a_of_type_ComTencentAvUiRedbagResultData + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.redbag.GameSink
 * JD-Core Version:    0.7.0.1
 */