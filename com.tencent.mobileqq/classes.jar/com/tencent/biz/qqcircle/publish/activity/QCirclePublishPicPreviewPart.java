package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._AppSetting;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._PhotoConst;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QAlbumConstants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._QQStoryMainActivity;
import com.tencent.biz.qqcircle.beans.QCirclePicPreviewInitBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.publish.bean.QCirclePicPreviewBean;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewMoveAdapter;
import com.tencent.biz.qqcircle.publish.preview.adapter.QCirclePicPreviewPagerAdapter;
import com.tencent.biz.qqcircle.publish.preview.helper.PicDragHelperCallback;
import com.tencent.biz.qqcircle.publish.preview.helper.PicItemDecoration;
import com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.ItemTouchHelper;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.widget.MultiPicViewPager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class QCirclePublishPicPreviewPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private ItemTouchHelper a;
  private PicDragHelperCallback c;
  private RecyclerView d;
  private QCirclePicPreviewMoveAdapter e;
  private QCirclePicPreviewPagerAdapter f;
  private MultiPicViewPager g;
  private QCirclePublishPicPreviewPart.TakePhotoHostEnvironmentLifeCycle h;
  private ImageView i;
  private TextView j;
  private QCirclePicPreviewInitBean k;
  private TextView l;
  private TextView m;
  private boolean n;
  
  private void a(int paramInt)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((QCirclePicPreviewMoveAdapter)localObject).a().size() != 0))
    {
      int i1 = this.e.a().size();
      this.l.setVisibility(0);
      this.l.setText(g().getResources().getString(2131895836, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(i1) }));
      if (!QCircleHostConstants._AppSetting.isPublicVersion()) {
        this.m.setText(((QCirclePicPreviewBean)this.e.a().get(paramInt)).b().toString());
      }
      return;
    }
    localObject = this.l;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  private void b(View paramView)
  {
    this.e = new QCirclePicPreviewMoveAdapter(paramView.getContext());
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(paramView.getContext());
    localLinearLayoutManager.setOrientation(0);
    this.d.setLayoutManager(localLinearLayoutManager);
    this.d.addItemDecoration(new PicItemDecoration(16));
    this.d.setAdapter(this.e);
    this.e.a(l());
    this.e.a(new QCirclePublishPicPreviewPart.3(this));
    this.c = new PicDragHelperCallback(this.e, null);
    this.c.a(1.2F);
    this.c.b(0.9F);
    this.c.a(new QCirclePublishPicPreviewPart.4(this, paramView));
    this.a = new ItemTouchHelper(this.c);
    this.a.a(this.d);
  }
  
  private void i()
  {
    if (c() == null) {
      return;
    }
    Intent localIntent = c().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean"))) {
      this.k = ((QCirclePicPreviewInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
    }
  }
  
  private ArrayList<QCirclePicPreviewBean> l()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.k;
    if (localObject != null)
    {
      if (((QCirclePicPreviewInitBean)localObject).getMediaInfoList() == null) {
        return localArrayList;
      }
      localObject = this.k.getMediaInfoList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        if (localLocalMediaInfo != null) {
          localArrayList.add(new QCirclePicPreviewBean(localLocalMediaInfo.path, localLocalMediaInfo));
        }
      }
    }
    return localArrayList;
  }
  
  private void m()
  {
    this.f = new QCirclePicPreviewPagerAdapter();
    this.f.a(this.e.a());
    this.g.setAdapter(this.f);
    this.g.addOnPageChangeListener(new QCirclePublishPicPreviewPart.2(this));
    a(0);
  }
  
  private void n()
  {
    if (this.e != null)
    {
      if (c() == null) {
        return;
      }
      Object localObject = this.e.a();
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((QCirclePicPreviewBean)((Iterator)localObject).next()).b());
      }
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("publish_pic_preview_result_data_key", localArrayList);
      c().setResult(-1, (Intent)localObject);
      c().finish();
    }
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    QCirclePicPreviewInitBean localQCirclePicPreviewInitBean = this.k;
    if ((localQCirclePicPreviewInitBean != null) && (localQCirclePicPreviewInitBean.getMediaInfoList() != null)) {
      localIntent.putParcelableArrayListExtra("publish_pic_preview_result_data_key", new ArrayList(this.k.getMediaInfoList()));
    }
    c().setResult(0, localIntent);
    c().finish();
  }
  
  public String a()
  {
    return "QCirclePublishPicPreviewPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    HostUIHelper.closeHostEnvironment();
    if ((QCircleHostConstants._QQStoryMainActivity.REQUEST_CODE_TAKE_VIDEO() == paramInt1) && (paramInt2 == -1))
    {
      Object localObject2 = paramIntent.getStringArrayListExtra(QCircleHostConstants._PhotoConst.PHOTO_PATHS());
      Object localObject1 = (HashMap)paramIntent.getSerializableExtra(QCircleHostConstants._QAlbumConstants.SELECTED_MEDIA_INFO_HASH_MAP());
      if (localObject2 != null)
      {
        if (((ArrayList)localObject2).size() == 0) {
          return;
        }
        paramIntent = new ArrayList();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          paramIntent.add(new QCirclePicPreviewBean(str, (LocalMediaInfo)((HashMap)localObject1).get(str)));
        }
        localObject1 = this.e;
        if ((localObject1 != null) && (this.f != null))
        {
          ((QCirclePicPreviewMoveAdapter)localObject1).a(paramIntent);
          this.f.a(this.e.a());
          localObject1 = this.g;
          if (localObject1 != null) {
            a(((MultiPicViewPager)localObject1).getCurrentItem());
          }
        }
        if (paramIntent.size() > 0) {
          this.n = true;
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.d = ((RecyclerView)paramView.findViewById(2131445214));
    this.g = ((MultiPicViewPager)paramView.findViewById(2131450005));
    this.i = ((ImageView)paramView.findViewById(2131436275));
    this.j = ((TextView)paramView.findViewById(2131448459));
    this.l = ((TextView)paramView.findViewById(2131448641));
    this.m = ((TextView)paramView.findViewById(2131440271));
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    if (!QCircleHostConstants._AppSetting.isPublicVersion()) {
      paramView.findViewById(2131445043).setOnLongClickListener(new QCirclePublishPicPreviewPart.1(this));
    }
    i();
    b(paramView);
    m();
  }
  
  public boolean ah_()
  {
    if (this.n)
    {
      QCirclePublishPicPreviewPart.5 local5 = new QCirclePublishPicPreviewPart.5(this);
      QCircleCustomDialog.a(g(), HardCodeUtil.a(2131895834), null, 2131887648, 2131895835, local5, local5).show();
    }
    else
    {
      o();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131436275) {
      ah_();
    } else if (i1 == 2131448459) {
      n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishPicPreviewPart
 * JD-Core Version:    0.7.0.1
 */