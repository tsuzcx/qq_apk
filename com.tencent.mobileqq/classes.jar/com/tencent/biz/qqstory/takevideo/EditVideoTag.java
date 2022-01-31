package com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter;
import com.tencent.biz.qqstory.takevideo.tag.IEditVideoTagView;
import com.tencent.biz.qqstory.takevideo.tag.QQStoryTagAdapter;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import ogv;
import ogw;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoTag
  extends EditVideoPart
  implements View.OnClickListener, EditVideoTagExport, IEditVideoTagView, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private EditVideoTag.TakeVideoTag jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag;
  private QQStoryTagAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter;
  private QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = QQStoryContext.a().a().createEntityManager();
  private List jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  private View f;
  
  public EditVideoTag(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private EditVideoTag.EditBehavior a()
  {
    EditVideoTag.EditBehavior localEditBehavior = new EditVideoTag.EditBehavior();
    EditMusicExport localEditMusicExport = (EditMusicExport)a(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.a(localEditBehavior);
    }
    return localEditBehavior;
  }
  
  @Nonnull
  private EditVideoTagPresenter a(int paramInt)
  {
    Object localObject2 = (EditVideoTagPresenter)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new EditVideoTagPresenter(this, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
      ((EditVideoTagPresenter)localObject1).a();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag != null)
      {
        localObject2 = new TagItem(new TagItem.TagInfoBase(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag.c);
        ((EditVideoTagPresenter)localObject1).a().add(localObject2);
        ((EditVideoTagPresenter)localObject1).a((TagItem)localObject2);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(@Nullable TagItem paramTagItem, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramTagItem == null)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramTagItem.a.jdField_a_of_type_JavaLangString);
  }
  
  private void a(List paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((TagItem)paramList.next()).a.jdField_a_of_type_Int == 1) {
        paramList.remove();
      }
    }
  }
  
  private void b(int paramInt)
  {
    TagItem localTagItem = a(paramInt).a();
    if (localTagItem == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("标签");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localTagItem.a.jdField_a_of_type_JavaLangString);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371643));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363245));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364638));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363116);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370826);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362951);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131371639);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131371640);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371641));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371642));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter = new QQStoryTagAdapter(a());
      h();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new ogv(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new ogw(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.b.setHeaderBgColor(0);
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void j()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void k()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void m()
  {
    Object localObject = a(this.jdField_a_of_type_Int).a();
    TagItem localTagItem = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a();
    int i;
    if ((localObject == null) && (localTagItem != null))
    {
      i = 1;
      if (this.jdField_b_of_type_Int != 1) {
        break label121;
      }
    }
    label121:
    for (localObject = "1";; localObject = "2")
    {
      StoryReportor.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.jdField_a_of_type_Int).a(localTagItem);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
      if ((localObject != null) && (localTagItem != null) && (!((TagItem)localObject).equals(localTagItem)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localTagItem == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public TagItem a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.d()))
    {
      SLog.e("Q.qqstory.detail.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.d()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131364354));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131367250));
    String str1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("video_tag_info");
    if (str1 != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag$TakeVideoTag = ((EditVideoTag.TakeVideoTag)JsonORM.a(new JSONObject(str1), EditVideoTag.TakeVideoTag.class));
      b(this.jdField_a_of_type_Int);
      a(EditVideoTagExport.class, this);
      this.jdField_b_of_type_Int = ((Integer)((StoryConfigManager)SuperManager.a(10)).b("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
      if (this.jdField_b_of_type_Int == 1)
      {
        str1 = "1";
        StoryReportor.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.jdField_a_of_type_JavaUtilList = EditVideoTagPresenter.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        SLog.b("Q.qqstory.detail.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        SLog.b("Q.qqstory.detail.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void a(int paramInt)
  {
    EditVideoTagPresenter localEditVideoTagPresenter = (EditVideoTagPresenter)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localEditVideoTagPresenter == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localEditVideoTagPresenter.a().remove(localEditVideoTagPresenter.a());
    localEditVideoTagPresenter.a(null);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    SLog.b("Q.qqstory.detail.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      c(8);
      return;
    case 28: 
      e();
      paramObject = a(this.jdField_a_of_type_Int);
      EditVideoTag.EditBehavior localEditBehavior = a();
      if ((paramObject.a() != null) && (!paramObject.a().isEmpty()))
      {
        l();
        if (!paramObject.a(localEditBehavior)) {
          if (paramObject.a() != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.a().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a(paramObject.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a(paramObject.a());
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.notifyDataSetChanged();
          a(paramObject.a(), false);
          c(0);
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.a(localEditBehavior);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramObject.a(this.jdField_a_of_type_JavaUtilList);
        l();
      }
      for (;;)
      {
        paramObject.a(localEditBehavior);
        break;
        k();
      }
    }
    b(this.jdField_a_of_type_Int);
    c(8);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    SLog.a("Q.qqstory.detail.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    TagItem localTagItem = a(paramInt).a();
    if (localTagItem == null)
    {
      SLog.a("Q.qqstory.detail.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    SLog.a("Q.qqstory.detail.EditVideoTag", "fragmentIndex=%s has tag, tag=", Integer.valueOf(paramInt), localTagItem.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localTagItem.a.jdField_a_of_type_Long);
    localTagInfoBase.tag_type.set(localTagItem.a.jdField_a_of_type_Int);
    localTagInfoBase.tag_name.set(localTagItem.a.jdField_a_of_type_JavaLangString);
    localTagInfoBase.tag_desc.set(localTagItem.a.jdField_b_of_type_JavaLangString);
    paramGenerateContext.a.tagInfoBytes = localTagInfoBase.toByteArray();
  }
  
  public void a(int paramInt, @Nonnull List paramList, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
    if (paramInt == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((QQStoryPullToRefreshListView)localObject).a(paramBoolean);
      if (paramInt != 0) {
        break label104;
      }
      if (!paramList.isEmpty()) {
        break;
      }
      i();
      return;
    }
    l();
    TagItem localTagItem = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a();
    localObject = localTagItem;
    if (!paramList.contains(localTagItem)) {
      localObject = null;
    }
    a((TagItem)localObject, false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a((TagItem)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.notifyDataSetChanged();
    return;
    label104:
    if (paramList.isEmpty())
    {
      j();
      a(null, true);
      return;
    }
    l();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.jdField_a_of_type_Int).a();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (TagItem)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a(paramAdapterView);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.jdField_b_of_type_Int != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      StoryReportor.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a(null);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a();
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(int paramInt, @Nonnull List paramList, boolean paramBoolean)
  {
    Object localObject = null;
    TagItem localTagItem;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        i();
        return;
      }
      l();
      localTagItem = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a();
      if (paramList.contains(localTagItem)) {
        break label102;
      }
    }
    for (;;)
    {
      a((TagItem)localObject, false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a((TagItem)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a(paramList);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.notifyDataSetChanged();
      return;
      if (paramList.isEmpty())
      {
        j();
        a(null, true);
        return;
      }
      l();
      return;
      label102:
      localObject = localTagItem;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363245: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      return;
    case 2131364638: 
      m();
      return;
    case 2131370826: 
      k();
      paramView = a();
      a(this.jdField_a_of_type_Int).a(paramView);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.a(null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTagQQStoryTagAdapter.notifyDataSetChanged();
    a(null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoTag
 * JD-Core Version:    0.7.0.1
 */