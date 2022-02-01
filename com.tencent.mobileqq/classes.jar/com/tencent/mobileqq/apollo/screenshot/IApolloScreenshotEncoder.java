package com.tencent.mobileqq.apollo.screenshot;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "", "addFrame", "", "pixels", "", "width", "", "height", "close", "encode", "", "outputFilePath", "", "frameTime", "getFrameCount", "init", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloScreenshotEncoder
{
  public abstract int a();
  
  public abstract void a();
  
  public abstract void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract boolean a(@NotNull String paramString, int paramInt);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.IApolloScreenshotEncoder
 * JD-Core Version:    0.7.0.1
 */