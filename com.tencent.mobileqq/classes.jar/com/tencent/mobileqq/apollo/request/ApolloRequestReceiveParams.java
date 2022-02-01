package com.tencent.mobileqq.apollo.request;

import android.content.Intent;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams;", "", "()V", "data", "", "handler", "Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionHandler;", "qqAppInterface", "Lcom/tencent/mobileqq/app/QQAppInterface;", "request", "Landroid/content/Intent;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloRequestReceiveParams
{
  @JvmField
  @Nullable
  public QQAppInterface a;
  @JvmField
  @Nullable
  public Intent b;
  @JvmField
  @Nullable
  public FromServiceMsg c;
  @JvmField
  @NotNull
  public byte[] d = new byte[0];
  @JvmField
  @Nullable
  public ApolloExtensionHandler e;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.ApolloRequestReceiveParams
 * JD-Core Version:    0.7.0.1
 */