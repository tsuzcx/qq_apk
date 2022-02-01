package com.tencent.luggage.opensdk;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/QRCodeTransferLongPullingConnect$LongPullingCallback;", "", "onCancelled", "", "onConfirmed", "result", "", "onConnectError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onQRCodeExpired", "onQRCodeScanned", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public abstract interface n$b
{
  public abstract void a();
  
  public abstract void a(@NotNull Exception paramException);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.n.b
 * JD-Core Version:    0.7.0.1
 */