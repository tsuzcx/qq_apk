package com.tencent.ark;

class ArkViewModelBase$21
  implements Runnable
{
  ArkViewModelBase$21(ArkViewModelBase paramArkViewModelBase, ArkViewImplement paramArkViewImplement) {}
  
  public void run()
  {
    ArkViewImplement localArkViewImplement = this.val$viewImpl;
    if (localArkViewImplement != null) {
      localArkViewImplement.onFirstPaint();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkViewModelBase.21
 * JD-Core Version:    0.7.0.1
 */