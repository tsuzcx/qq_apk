package com.tencent.biz.qqcircle.publish.preview;

import android.content.Intent;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

public class QCircleUploadPreviewerFragment
  extends QCircleBaseFragment
{
  private List<Part> c;
  private QCircleViewerPart d;
  private QCircleVideoPreviewPart e;
  
  private boolean a(Intent paramIntent)
  {
    return paramIntent.getBooleanExtra("key_photo_previewer_is_video", false);
  }
  
  public int a()
  {
    return -1;
  }
  
  public String b()
  {
    return "[QcirclePublish]QCircleUploadPreviewerFragment";
  }
  
  public boolean bh_()
  {
    return false;
  }
  
  protected int c()
  {
    return 2131626930;
  }
  
  protected List<Part> d()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      if (!a(getActivity().getIntent()))
      {
        this.d = new QCircleViewerPart();
        this.d.a(getActivity().getIntent());
        this.c.add(this.d);
      }
      else
      {
        this.e = new QCircleVideoPreviewPart();
        this.e.a(getActivity().getIntent());
        this.c.add(this.e);
      }
    }
    return this.c;
  }
  
  protected String f()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      if (a(getActivity().getIntent())) {
        return "pg_xsj_publish_page_preview_videos";
      }
      return "pg_xsj_publish_page_preview_pics";
    }
    return "";
  }
  
  protected int j()
  {
    return getResources().getColor(2131168376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.QCircleUploadPreviewerFragment
 * JD-Core Version:    0.7.0.1
 */