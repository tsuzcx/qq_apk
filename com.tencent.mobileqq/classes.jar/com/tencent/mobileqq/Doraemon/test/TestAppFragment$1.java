package com.tencent.mobileqq.Doraemon.test;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;

class TestAppFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  TestAppFragment$1(TestAppFragment paramTestAppFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      new File(this.a.a).mkdirs();
      File localFile = new File(this.a.a, this.a.b);
      try
      {
        localFile.createNewFile();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    else
    {
      new File(this.a.a, this.a.b).delete();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.1
 * JD-Core Version:    0.7.0.1
 */