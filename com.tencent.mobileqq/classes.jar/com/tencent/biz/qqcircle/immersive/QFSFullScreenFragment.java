package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.immersive.part.QFSFullScreenVideoPart;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

public class QFSFullScreenFragment
  extends QFSBaseFragment
{
  public int a()
  {
    return 0;
  }
  
  public String b()
  {
    return "QFSFullScreenFragment";
  }
  
  protected int c()
  {
    return 2131627172;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new QFSFullScreenVideoPart());
    return localArrayList;
  }
  
  protected String f()
  {
    return "pg_xsj_full_screen_page";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getActivity().setRequestedOrientation(0);
    getActivity().getWindow().addFlags(1024);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSFullScreenFragment
 * JD-Core Version:    0.7.0.1
 */