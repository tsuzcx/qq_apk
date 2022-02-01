package com.tencent.mobileqq.app.fms;

class FullMessageSearchManager$1
  implements SearchListener
{
  FullMessageSearchManager$1(FullMessageSearchManager paramFullMessageSearchManager) {}
  
  public void a(FullMessageSearchResult paramFullMessageSearchResult)
  {
    FullMessageSearchManager.a(this.a);
    this.a.notifyObservers(paramFullMessageSearchResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.FullMessageSearchManager.1
 * JD-Core Version:    0.7.0.1
 */