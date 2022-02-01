package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFPreviewWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter;
import com.tencent.aelight.camera.ae.gif.video.PngCreateResult;
import com.tencent.aelight.camera.ae.gif.video.PngCreateResult.PngResultItem;
import com.tencent.aelight.camera.ae.gif.video.PngsCreateWorkingQueue;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class AEGIFChunkPreviewFragment$3
  implements View.OnClickListener
{
  AEGIFChunkPreviewFragment$3(AEGIFChunkPreviewFragment paramAEGIFChunkPreviewFragment) {}
  
  public void onClick(View paramView)
  {
    AEGIFChunkPreviewFragment.a(this.a, true);
    Set localSet = AEGIFChunkPreviewFragment.b(this.a).a();
    paramView = new StringBuilder();
    paramView.append("save button click, selectedItems = ");
    paramView.append(localSet);
    QLog.d("AEGIFChunkPreviewFragment", 4, paramView.toString());
    Object localObject = AEBaseReportParam.a();
    ((AEBaseReportParam)localObject).R();
    paramView = new LinkedList();
    int j = 0;
    int i = 0;
    while (i < AEGIFChunkPreviewFragment.a(this.a).size())
    {
      if (localSet.contains(Integer.valueOf(i)))
      {
        if (((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).c != null)
        {
          ((AEBaseReportParam)localObject).C(((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).c.id);
          ((AEBaseReportParam)localObject).A("none");
          ((AEBaseReportParam)localObject).B("none");
          paramView.add(((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).c.id);
        }
        else if (!((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).d.equals(""))
        {
          ((AEBaseReportParam)localObject).C("none");
          ((AEBaseReportParam)localObject).A(((AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.b.get(AEGIFTextColorConfig.a[(i % AEGIFTextColorConfig.a.length)])).a);
          ((AEBaseReportParam)localObject).B(((AEGIFPreviewWrapper)AEGIFChunkPreviewFragment.a(this.a).get(i)).d);
          paramView.add("none");
        }
        else
        {
          ((AEBaseReportParam)localObject).C("none");
          ((AEBaseReportParam)localObject).A("none");
          ((AEBaseReportParam)localObject).B("none");
          paramView.add("none");
        }
        AEBaseDataReporter.a().aw();
      }
      i += 1;
    }
    localObject = new StringBuilder();
    i = 0;
    while (i < paramView.size())
    {
      ((StringBuilder)localObject).append((String)paramView.get(i));
      if (i != paramView.size() - 1) {
        ((StringBuilder)localObject).append(",");
      }
      i += 1;
    }
    AEBaseDataReporter.a().a(localSet.size(), ((StringBuilder)localObject).toString());
    AEGIFChunkPreviewFragment.d(this.a).a(false);
    PngCreateResult localPngCreateResult = AEGIFChunkPreviewFragment.d(this.a).a();
    paramView = new StringBuilder();
    paramView.append("save button click, pngDirs = ");
    paramView.append(localPngCreateResult.a);
    paramView.append(", texts = ");
    paramView.append(localPngCreateResult.b);
    QLog.d("AEGIFChunkPreviewFragment", 4, paramView.toString());
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    i = j;
    while (i < localPngCreateResult.a.size())
    {
      Integer localInteger = (Integer)localPngCreateResult.d.get(i);
      if (localSet.contains(localInteger))
      {
        if ((i == 0) && (AEGIFChunkPreviewFragment.e(this.a) != null))
        {
          localArrayList1.add(AEGIFChunkPreviewFragment.e(this.a).a);
          localArrayList2.add(AEGIFChunkPreviewFragment.e(this.a).b);
          localArrayList3.add(AEGIFChunkPreviewFragment.e(this.a).c);
        }
        else
        {
          localArrayList1.add(localPngCreateResult.a.get(i));
          localArrayList2.add(localPngCreateResult.b.get(i));
          localArrayList3.add(localPngCreateResult.c.get(i));
        }
        localObject = AEGIFChunkPreviewFragment.a(this.a, localInteger.intValue());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("gif^");
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localStringBuilder.append(paramView);
        paramView = localStringBuilder.toString();
        localArrayList4.add(paramView);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save gif, index=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", widgetInfo=");
        ((StringBuilder)localObject).append(paramView);
        ((StringBuilder)localObject).append(", originIndex=");
        ((StringBuilder)localObject).append(localInteger);
        AEQLog.b("AEGIFChunkPreviewFragment", ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
    AEGIFChunkPreviewFragment.a(this.a, localArrayList1, localArrayList2, localArrayList3, localArrayList4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFChunkPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */