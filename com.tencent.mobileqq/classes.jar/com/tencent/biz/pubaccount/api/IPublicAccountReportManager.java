package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IPublicAccountReportManager
  extends IRuntimeService
{
  public abstract void addReporting(Entity paramEntity);
  
  public abstract void scheduleReport();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountReportManager
 * JD-Core Version:    0.7.0.1
 */