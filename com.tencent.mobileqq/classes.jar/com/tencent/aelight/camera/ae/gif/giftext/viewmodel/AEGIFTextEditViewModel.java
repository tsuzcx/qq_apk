package com.tencent.aelight.camera.ae.gif.giftext.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import com.tencent.aelight.camera.ae.gif.video.PngCreateResult.PngResultItem;
import com.tencent.aelight.camera.aebase.Util;
import java.io.File;
import java.util.List;

public class AEGIFTextEditViewModel
  extends ViewModel
{
  private MutableLiveData<AEGIFTextColorConfig.SmartTextColor> a = new MutableLiveData();
  private MutableLiveData<String> b = new MutableLiveData();
  private MutableLiveData<PngCreateResult.PngResultItem> c = new MutableLiveData();
  
  public MutableLiveData<AEGIFTextColorConfig.SmartTextColor> a()
  {
    return this.a;
  }
  
  public void a()
  {
    this.a.postValue(new AEGIFTextColorConfig.SmartTextColor("#ccffffff", "#000000"));
    this.b.postValue("");
  }
  
  public void a(String paramString, int paramInt)
  {
    this.b.postValue(paramString);
    this.a.postValue(AEGIFTextColorConfig.a.get(paramInt));
  }
  
  public void a(String paramString1, String paramString2)
  {
    PngCreateResult.PngResultItem localPngResultItem = new PngCreateResult.PngResultItem();
    String[] arrayOfString = new File(paramString2).list();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("snapshot.png");
    localObject = ((StringBuilder)localObject).toString();
    if (arrayOfString.length != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(arrayOfString[0]);
      Util.a(localStringBuilder.toString(), 320, 320, (String)localObject);
    }
    localPngResultItem.a = paramString2;
    localPngResultItem.b = paramString1;
    localPngResultItem.c = ((String)localObject);
    this.c.postValue(localPngResultItem);
  }
  
  public MutableLiveData<String> b()
  {
    return this.b;
  }
  
  public MutableLiveData<PngCreateResult.PngResultItem> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel
 * JD-Core Version:    0.7.0.1
 */