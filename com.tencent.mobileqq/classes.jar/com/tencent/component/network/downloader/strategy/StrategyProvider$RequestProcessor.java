package com.tencent.component.network.downloader.strategy;

import org.apache.http.HttpRequest;

public abstract interface StrategyProvider$RequestProcessor
{
  public abstract void prepareRequest(String paramString, HttpRequest paramHttpRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.StrategyProvider.RequestProcessor
 * JD-Core Version:    0.7.0.1
 */