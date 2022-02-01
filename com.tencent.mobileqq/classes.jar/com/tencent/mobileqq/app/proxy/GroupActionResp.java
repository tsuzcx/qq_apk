package com.tencent.mobileqq.app.proxy;

import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;

public class GroupActionResp
{
  public int a;
  public int b;
  public String c;
  public AddGroupResp d;
  public RenameGroupResp e;
  public DelGroupResp f;
  public ReSortGroupResp g;
  
  public GroupActionResp(int paramInt, String paramString, AddGroupResp paramAddGroupResp)
  {
    this.a = 1;
    this.b = paramInt;
    this.d = paramAddGroupResp;
    this.c = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, DelGroupResp paramDelGroupResp)
  {
    this.a = 3;
    this.b = paramInt;
    this.f = paramDelGroupResp;
    this.c = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, ReSortGroupResp paramReSortGroupResp)
  {
    this.a = 4;
    this.b = paramInt;
    this.g = paramReSortGroupResp;
    this.c = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, RenameGroupResp paramRenameGroupResp)
  {
    this.a = 2;
    this.b = paramInt;
    this.e = paramRenameGroupResp;
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.GroupActionResp
 * JD-Core Version:    0.7.0.1
 */