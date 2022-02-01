package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.widget.QQToast;

class ApolloPanel$30$1
  implements Runnable
{
  ApolloPanel$30$1(ApolloPanel.30 param30, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.a)
    {
      QQToast.makeText(this.b.c.getContext(), 1, this.b.a, 0).show();
      return;
    }
    this.b.c.i();
    QQToast.makeText(this.b.c.getContext(), 2, this.b.b, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.30.1
 * JD-Core Version:    0.7.0.1
 */