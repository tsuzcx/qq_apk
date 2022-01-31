package com.tencent.mobileqq.apollo;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloGameLoadDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import yjx;

public class ApolloGameNormalStartHandler
{
  private long jdField_a_of_type_Long;
  private ApolloGameLoadDialog jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameLoadDialog;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference b;
  
  public ApolloGameNormalStartHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameLoadDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameLoadDialog.dismiss();
    }
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    if (paramActivity == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 2000L)
    {
      QLog.e("ApolloGameNormalStartHandler", 1, "current - mLastLuanchGameTime < 2000");
      return;
    }
    this.jdField_a_of_type_Long = l;
    this.b = new WeakReference(paramActivity);
    paramActivity.runOnUiThread(new yjx(this, paramInt1, paramInt2, paramInt3, localQQAppInterface, paramString2, paramInt4, paramString1, paramActivity));
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameNormalStartHandler", 2, new Object[] { "startGameFromArkApp, args:", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int j = paramString.getInt("gameID");
        int k = paramString.getInt("gameMode");
        int m = paramString.getInt("src");
        String str = paramString.optString("gameParam");
        paramString = "";
        Object localObject = BaseActivity.sTopActivity;
        if (!(BaseActivity.sTopActivity instanceof FragmentActivity)) {
          break label194;
        }
        ChatFragment localChatFragment = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        if (localChatFragment == null) {
          break label194;
        }
        localObject = localChatFragment.a();
        if (((BaseChatPie)localObject).a() != null)
        {
          i = ((BaseChatPie)localObject).a().jdField_a_of_type_Int;
          paramString = ((BaseChatPie)localObject).a().jdField_a_of_type_JavaLangString;
          localObject = ((BaseChatPie)localObject).a();
          a((Activity)localObject, j, k, str, i, paramString, m);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloGameNormalStartHandler", 1, paramString, new Object[0]);
        return;
      }
      int i = 0;
      continue;
      label194:
      i = 0;
    }
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameNormalStartHandler
 * JD-Core Version:    0.7.0.1
 */