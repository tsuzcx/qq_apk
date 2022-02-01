package com.tencent.biz.pubaccount.readinjoy.ugc.databinding;

final class ListChangeRegistry$1
  extends CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChangeRegistry.ListChanges>
{
  public void a(ObservableList.OnListChangedCallback paramOnListChangedCallback, ObservableList paramObservableList, int paramInt, ListChangeRegistry.ListChanges paramListChanges)
  {
    switch (paramInt)
    {
    default: 
      paramOnListChangedCallback.a(paramObservableList);
      return;
    case 1: 
      paramOnListChangedCallback.a(paramObservableList, paramListChanges.a, paramListChanges.b);
      return;
    case 2: 
      paramOnListChangedCallback.b(paramObservableList, paramListChanges.a, paramListChanges.b);
      return;
    case 3: 
      paramOnListChangedCallback.a(paramObservableList, paramListChanges.a, paramListChanges.c, paramListChanges.b);
      return;
    }
    paramOnListChangedCallback.c(paramObservableList, paramListChanges.a, paramListChanges.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ListChangeRegistry.1
 * JD-Core Version:    0.7.0.1
 */