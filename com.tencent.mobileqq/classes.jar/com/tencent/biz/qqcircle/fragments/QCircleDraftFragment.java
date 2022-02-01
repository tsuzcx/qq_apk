package com.tencent.biz.qqcircle.fragments;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.bizparts.QCircleDraftPart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

public class QCircleDraftFragment
  extends QCircleBaseFragment
{
  public int a()
  {
    return 33;
  }
  
  public String b()
  {
    return "QCircleDraftFragment";
  }
  
  protected int c()
  {
    return 2131626843;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    QCircleDraftPart localQCircleDraftPart = new QCircleDraftPart();
    localQCircleDraftPart.a(n());
    localArrayList.add(localQCircleDraftPart);
    return localArrayList;
  }
  
  protected String f()
  {
    return "pg_xsj_publish_draftbox_page";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      getActivity().getWindow().setSoftInputMode(32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleDraftFragment
 * JD-Core Version:    0.7.0.1
 */