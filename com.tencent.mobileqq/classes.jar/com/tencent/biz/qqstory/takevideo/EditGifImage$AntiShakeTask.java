package com.tencent.biz.qqstory.takevideo;

import android.os.AsyncTask;
import cooperation.qzone.util.GifAntishakeModule;
import cooperation.qzone.util.GifAntishakeModule.postProgressListener;
import java.util.ArrayList;

public class EditGifImage$AntiShakeTask
  extends AsyncTask
  implements GifAntishakeModule.postProgressListener
{
  private int jdField_a_of_type_Int;
  
  public EditGifImage$AntiShakeTask(EditGifImage paramEditGifImage) {}
  
  protected ArrayList a(ArrayList... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (isCancelled())) {
      return null;
    }
    ArrayList localArrayList2 = paramVarArgs[0];
    ArrayList localArrayList1 = new ArrayList();
    this.jdField_a_of_type_Int = localArrayList2.size();
    GifAntishakeModule.a().a(this);
    paramVarArgs = localArrayList1;
    if (!isCancelled()) {}
    try
    {
      paramVarArgs = GifAntishakeModule.a().a(localArrayList2);
      localArrayList2.clear();
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        paramVarArgs = localArrayList1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    publishProgress(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1) || (isCancelled())) {}
    do
    {
      return;
      EditGifImage.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage, paramArrayList);
    } while (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.e);
    EditGifImage.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.a.a(true, true);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.e) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.a.a(paramVarArgs[0].intValue(), this.jdField_a_of_type_Int);
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage.AntiShakeTask
 * JD-Core Version:    0.7.0.1
 */