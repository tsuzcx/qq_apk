package com.tencent.biz.qqcircle.debug.mocklbs;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

public class QCircleMockLbsFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return -1;
  }
  
  public String b()
  {
    return "QCircleMockLbsFragment";
  }
  
  protected int c()
  {
    return 2131626885;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new QCircleMockLbsPart());
    return localArrayList;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.debug.mocklbs.QCircleMockLbsFragment
 * JD-Core Version:    0.7.0.1
 */