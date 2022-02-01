package com.tencent.biz.qqcircle.immersive;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.immersive.events.QFSFolderLazyInitEvent;
import com.tencent.biz.qqcircle.immersive.part.folder.IPageChangeObserver;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QFSFolderProfileFragment
  extends QFSPersonalDetailsFragment
  implements IPageChangeObserver
{
  private boolean e = false;
  
  public QFSFolderProfileFragment()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("qfs_key_bundle_personal_fragment_scene", "qfs_personal_fragment_scene_home_owner");
    setArguments(localBundle);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QFSFolderPersonalDetailsFragment", 1, "onPageSelect");
    w();
  }
  
  protected void a(@NonNull QFSFolderLazyInitEvent paramQFSFolderLazyInitEvent)
  {
    if (paramQFSFolderLazyInitEvent.getLazyInitType() == x()) {
      paramQFSFolderLazyInitEvent.execute(new QFSFolderProfileFragment.1(this));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QFSFolderLazyInitEvent.class);
    return localArrayList;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QFSFolderLazyInitEvent)) {
      a((QFSFolderLazyInitEvent)paramSimpleBaseEvent);
    }
  }
  
  void u() {}
  
  protected void w()
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      if (!this.e)
      {
        this.e = true;
        y();
        A();
        QLog.d("QFSFolderPersonalDetailsFragment", 1, "lazyInit");
      }
    }
  }
  
  public int x()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSFolderProfileFragment
 * JD-Core Version:    0.7.0.1
 */