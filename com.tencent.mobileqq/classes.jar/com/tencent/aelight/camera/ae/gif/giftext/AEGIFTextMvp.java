package com.tencent.aelight.camera.ae.gif.giftext;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFSmartTextAdapter;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFRecommandTextViewModel;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AEGIFTextMvp
  implements AEGIFTextListener
{
  public static final List<String> a = Arrays.asList(new String[] { HardCodeUtil.a(2131898243), HardCodeUtil.a(2131898254), HardCodeUtil.a(2131898252), HardCodeUtil.a(2131898259), HardCodeUtil.a(2131898263), HardCodeUtil.a(2131898260), "dbq", "886", HardCodeUtil.a(2131898257), HardCodeUtil.a(2131898256), HardCodeUtil.a(2131898247), "ok", "666", HardCodeUtil.a(2131898249), HardCodeUtil.a(2131898265), HardCodeUtil.a(2131898258) });
  private HashMap<String, String> b;
  private BaseVMPeakActivity c;
  private RelativeLayout d;
  private RecyclerView e;
  private ImageView f;
  private TextView g;
  private ProgressBar h;
  private StaggeredGridLayoutManager i;
  private AEGIFSmartTextAdapter j;
  private AEGIFOutlineTextView k;
  private String l;
  private int m = 0;
  private ArrayList<String> n;
  private boolean o = false;
  
  public AEGIFTextMvp(BaseVMPeakActivity paramBaseVMPeakActivity, RelativeLayout paramRelativeLayout, AEGIFOutlineTextView paramAEGIFOutlineTextView)
  {
    this.c = paramBaseVMPeakActivity;
    this.d = paramRelativeLayout;
    paramBaseVMPeakActivity = this.d;
    if (paramBaseVMPeakActivity != null)
    {
      this.g = ((TextView)paramBaseVMPeakActivity.findViewById(2063991348));
      this.h = ((ProgressBar)this.d.findViewById(2063991426));
      this.e = ((RecyclerView)this.d.findViewById(2063991349));
      this.f = ((ImageView)this.d.findViewById(2063991345));
    }
    this.k = paramAEGIFOutlineTextView;
    this.b = new HashMap();
    this.b.put("happy", HardCodeUtil.a(2131898267));
    this.b.put("neutral", HardCodeUtil.a(2131898244));
    this.b.put("sad", HardCodeUtil.a(2131898250));
    this.b.put("anger", HardCodeUtil.a(2131898261));
    this.b.put("disgust", HardCodeUtil.a(2131898253));
    this.b.put("fear", HardCodeUtil.a(2131898248));
  }
  
  private void b(String paramString1, String paramString2, String paramString3)
  {
    this.k.setText(paramString1);
    ViewGroup.LayoutParams localLayoutParams = this.k.getLayoutParams();
    int i1;
    if (paramString1.indexOf('\n') > 0) {
      i1 = DisplayUtil.a(this.c, 73.199997F);
    } else {
      i1 = DisplayUtil.a(this.c, 41.0F);
    }
    localLayoutParams.height = i1;
    this.k.setLayoutParams(localLayoutParams);
    this.k.setTextColor(paramString2);
    this.k.setOutlineColor(paramString3);
    this.k.setOutlineWidth(DisplayUtil.a(this.c, 4.0F));
    if (paramString1.indexOf('\n') > 0) {
      i1 = DisplayUtil.a(this.c, 26.0F);
    } else {
      i1 = DisplayUtil.a(this.c, 30.0F);
    }
    float f1 = i1;
    this.k.setTextSize(f1);
    this.k.invalidate();
  }
  
  public void a()
  {
    this.l = "";
    this.i = new StaggeredGridLayoutManager(2, 0);
    this.i.setGapStrategy(0);
    this.e.setLayoutManager(this.i);
    this.e.setItemAnimator(null);
    this.e.setVisibility(4);
    this.f.setVisibility(4);
    c();
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
    if (!this.n.contains(paramString))
    {
      AEGIFSmartTextAdapter localAEGIFSmartTextAdapter = this.j;
      if (localAEGIFSmartTextAdapter != null) {
        localAEGIFSmartTextAdapter.a();
      }
    }
    b(paramString);
    this.f.setImageResource(2063925621);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.k.setTextColor(paramString2);
    this.k.setOutlineColor(paramString3);
    a(paramString1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.k.setStroke(paramBoolean1);
    this.k.setShadow(paramBoolean2);
  }
  
  public void b()
  {
    Log.d("AEGIFTextMvp", "On loading completed...");
    this.h.setVisibility(4);
    this.j = new AEGIFSmartTextAdapter(this.c, this);
    this.j.setHasStableIds(true);
    this.e.setAdapter(this.j);
    this.e.setClipToPadding(false);
    this.e.setClipChildren(false);
    this.e.setVisibility(0);
    this.e.addOnScrollListener(new AEGIFTextMvp.1(this));
    this.f.setVisibility(0);
    this.f.setOnClickListener(new AEGIFTextMvp.2(this));
  }
  
  public void b(String paramString)
  {
    this.k.setText(paramString);
    this.k.setOutlineWidth(DisplayUtil.a(this.c, 4.0F));
    ViewGroup.LayoutParams localLayoutParams = this.k.getLayoutParams();
    AEGIFOutlineTextView localAEGIFOutlineTextView = this.k;
    int i1;
    if (paramString.indexOf('\n') > 0) {
      i1 = DisplayUtil.a(this.c, 26.0F);
    } else {
      i1 = DisplayUtil.a(this.c, 30.0F);
    }
    localAEGIFOutlineTextView.setTextSize(i1);
    if (paramString.indexOf('\n') > 0) {
      i1 = DisplayUtil.a(this.c, 73.199997F);
    } else {
      i1 = DisplayUtil.a(this.c, 41.0F);
    }
    localLayoutParams.height = i1;
    this.k.setLayoutParams(localLayoutParams);
  }
  
  public void c()
  {
    Log.d("AEGIFTextMvp", "On loading...");
    this.h.setVisibility(0);
    this.n = new ArrayList();
    d();
    AEGIFRecommandTextViewModel.a().observe(this.c, new AEGIFTextMvp.3(this));
  }
  
  public void d()
  {
    Log.d("AEGIFTextMvp", "Clearing smart text");
    this.f.setImageResource(2063925622);
    AEGIFSmartTextAdapter localAEGIFSmartTextAdapter = this.j;
    if (localAEGIFSmartTextAdapter != null) {
      localAEGIFSmartTextAdapter.a();
    }
    this.l = "";
    this.m = 0;
    a(false, true);
    this.k.setShadowParam(3.0F, 0.0F, 1.0F, "#73000000");
    b(HardCodeUtil.a(2131898264), "#ccffffff", "#000000");
  }
  
  public RecyclerView e()
  {
    return this.e;
  }
  
  public ArrayList<AEGIFSmartTextData> f()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.n.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new AEGIFSmartTextData((String)localIterator.next()));
    }
    return localArrayList;
  }
  
  public String g()
  {
    return this.l;
  }
  
  public int h()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp
 * JD-Core Version:    0.7.0.1
 */