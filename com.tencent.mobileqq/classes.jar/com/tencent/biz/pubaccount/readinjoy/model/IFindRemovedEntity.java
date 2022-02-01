package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;

public abstract interface IFindRemovedEntity<T extends Entity>
{
  public abstract Entity a(EntityManager paramEntityManager, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.IFindRemovedEntity
 * JD-Core Version:    0.7.0.1
 */