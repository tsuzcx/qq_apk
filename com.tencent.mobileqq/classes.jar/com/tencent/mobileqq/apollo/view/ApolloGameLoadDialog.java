package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.utils.QQCustomDialog;

public class ApolloGameLoadDialog
  extends QQCustomDialog
{
  ApolloGameProcessBar a;
  
  public void setProgress(int paramInt)
  {
    if (this.a != null) {
      this.a.setProgress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameLoadDialog
 * JD-Core Version:    0.7.0.1
 */