package com.tencent.mobileqq.activity.aio.rebuild;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessConvInfo;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessObserver;
import com.tencent.mobileqq.confess.ConfessProxy;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class ConfessChatPie$1
  extends ConfessObserver
{
  ConfessChatPie$1(ConfessChatPie paramConfessChatPie) {}
  
  private void a(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder;
    if ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      localStringBuilder = new StringBuilder();
      if (!paramBoolean) {}
    }
    else
    {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append("屏蔽失败，请重试。");
      this.a.a(2, localStringBuilder.toString(), 500);
      return;
    }
    localStringBuilder.append("屏蔽失败，").append(paramString);
    this.a.a(2, localStringBuilder.toString(), 500);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!ConfessConfig.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    do
    {
      do
      {
        return;
      } while ((!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) || (paramInt2 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
      ConfessChatPie.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.i(this.a.b, 2, "onCheckHolmesTipsView  frdUin:" + paramString + " type:" + paramInt2 + " topicid:" + paramInt1);
  }
  
  public void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (!ConfessConfig.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return;
    }
    if (paramBoolean2) {}
    for (;;)
    {
      String str = Long.toString(paramLong2);
      if ((!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e) || (paramInt2 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
        break;
      }
      if (paramBoolean1)
      {
        ConfessProxy localConfessProxy = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        ConfessConvInfo localConfessConvInfo = localConfessProxy.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
        if ((localConfessConvInfo != null) && ((localConfessConvInfo.holmesCurCount != paramInt3) || (localConfessConvInfo.holmesTolCount != paramInt4))) {
          localConfessProxy.a(str, paramInt2, paramInt1, paramInt3, paramInt4);
        }
        ConfessChatPie.a(this.a, true);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(this.a.b, 2, "onGetHolmesProgress " + paramBoolean1 + " frdUin:" + str + " type:" + paramInt2 + " topicid:" + paramInt1 + " curCount:" + paramInt3);
      return;
      paramLong2 = paramLong1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ConfessInfo paramConfessInfo)
  {
    String str;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && (paramInt2 == this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e)) {
      if (QLog.isColorLevel())
      {
        str = this.a.b;
        paramInt2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
        if (paramString2 != null) {
          break label162;
        }
      }
    }
    label162:
    for (paramConfessInfo = "";; paramConfessInfo = paramString2)
    {
      QLog.i(str, 2, String.format("onSetShieldFlag suc:%b frdUin:%s uinType:%d topicId:%d hours:%d msg:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramConfessInfo }));
      this.a.a();
      a(paramBoolean, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.1
 * JD-Core Version:    0.7.0.1
 */