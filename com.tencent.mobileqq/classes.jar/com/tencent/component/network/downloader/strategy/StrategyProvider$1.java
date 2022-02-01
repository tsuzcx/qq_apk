package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.utils.http.HttpUtil.RequestOptions;

final class StrategyProvider$1
  extends ThreadLocal<HttpUtil.RequestOptions>
{
  protected HttpUtil.RequestOptions initialValue()
  {
    return new HttpUtil.RequestOptions();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.StrategyProvider.1
 * JD-Core Version:    0.7.0.1
 */