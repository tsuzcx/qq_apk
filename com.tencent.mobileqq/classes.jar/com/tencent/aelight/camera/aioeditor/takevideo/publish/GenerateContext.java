package com.tencent.aelight.camera.aioeditor.takevideo.publish;

import android.view.View;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.tribe.data.TribeVideoPublishParams;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;

public class GenerateContext
{
  public final EditVideoParams a;
  public final int b;
  public final EditVideoParams.EditSource c;
  public final PublishVideoEntry d = new PublishVideoEntry();
  public int e = 1;
  public boolean f;
  public boolean g = false;
  public boolean h = false;
  public GenerateThumbArgs i;
  public String j;
  public WeakReference<View> k;
  public GeneratePicArgs l;
  public PublishParam m;
  public boolean n = false;
  public LpReportInfo_pf00064 o = new LpReportInfo_pf00064();
  public String p;
  public long q;
  public TribeVideoPublishParams r = new TribeVideoPublishParams();
  
  public GenerateContext(EditVideoParams paramEditVideoParams)
  {
    this.a = paramEditVideoParams;
    this.b = paramEditVideoParams.a;
    this.c = paramEditVideoParams.e;
    this.q = System.currentTimeMillis();
  }
  
  public View a()
  {
    WeakReference localWeakReference = this.k;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      this.k = null;
      return;
    }
    this.k = new WeakReference(paramView);
  }
  
  public boolean b()
  {
    return (this.f) || (this.l.f > 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GenerateContext{, businessId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext
 * JD-Core Version:    0.7.0.1
 */