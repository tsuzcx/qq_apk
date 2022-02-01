package com.tencent.mobileqq.apollo.api.web.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.player.ICMSRecordCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

class ApolloJsPluginImpl$3
  implements ICMSRecordCallback
{
  ApolloJsPluginImpl$3(ApolloJsPluginImpl paramApolloJsPluginImpl, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e("ApolloJsPlugin", 1, new Object[] { "recordAction fail ", Integer.valueOf(paramInt), paramString1, paramString2 });
    }
    while ((paramString2 == null) || (paramString1 == null)) {
      return;
    }
    ApolloJsPluginImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl).put(paramString2, new ApolloJsPluginImpl.AvatarInfo(paramString1, this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqApolloApiWebImplApolloJsPluginImpl.callbackRecordAction(paramString2, paramInt, this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl.3
 * JD-Core Version:    0.7.0.1
 */