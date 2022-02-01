package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.bizparts.QCircleDataEditContentPart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

public class QCircleDataEditFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 32;
  }
  
  public String b()
  {
    return "QCircleDataEditFragment";
  }
  
  protected int c()
  {
    return 2131626790;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    QCircleDataEditContentPart localQCircleDataEditContentPart = new QCircleDataEditContentPart();
    localQCircleDataEditContentPart.a(n());
    localArrayList.add(localQCircleDataEditContentPart);
    return localArrayList;
  }
  
  protected String f()
  {
    return "pg_xsj_profile_edit_page";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleDataEditFragment
 * JD-Core Version:    0.7.0.1
 */