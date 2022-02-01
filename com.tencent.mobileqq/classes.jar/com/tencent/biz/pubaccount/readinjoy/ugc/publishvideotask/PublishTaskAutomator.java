package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.biz.pubaccount.readinjoy.automator.Automator;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import org.jetbrains.annotations.NotNull;

public final class PublishTaskAutomator
  extends Automator
{
  @NotNull
  private UgcVideo a;
  
  public PublishTaskAutomator(@NotNull UgcVideo paramUgcVideo)
  {
    this.a = paramUgcVideo;
  }
  
  @NotNull
  public final UgcVideo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.PublishTaskAutomator
 * JD-Core Version:    0.7.0.1
 */