import android.graphics.Color;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.AdapterView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class bihb
  extends bifz
  implements View.OnClickListener, behi, bihh, bixk
{
  private int jdField_a_of_type_Int;
  private SparseArray<bixh> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atmp jdField_a_of_type_Atmp = QQStoryContext.a().a().createEntityManager();
  private bihg jdField_a_of_type_Bihg;
  private bixl jdField_a_of_type_Bixl;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private List<vik> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  private View f;
  
  public bihb(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  private bihf a()
  {
    bihf localbihf = new bihf();
    bibw localbibw = (bibw)a(bibw.class);
    if (localbibw != null) {
      localbibw.a(localbihf);
    }
    return localbihf;
  }
  
  @Nonnull
  private bixh a(int paramInt)
  {
    Object localObject2 = (bixh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new bixh(this, this.jdField_a_of_type_Atmp);
      ((bixh)localObject1).a();
      if (this.jdField_a_of_type_Bihg != null)
      {
        localObject2 = new vik(new vil(this.jdField_a_of_type_Bihg.jdField_a_of_type_Long, this.jdField_a_of_type_Bihg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bihg.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bihg.jdField_a_of_type_Int), this.jdField_a_of_type_Bihg.jdField_b_of_type_Int, this.jdField_a_of_type_Bihg.c);
        ((bixh)localObject1).a().add(localObject2);
        ((bixh)localObject1).a((vik)localObject2);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(List<vik> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((vik)paramList.next()).a.jdField_a_of_type_Int == 1) {
        paramList.remove();
      }
    }
  }
  
  private void a(@Nullable vik paramvik, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramvik == null)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramvik.a.jdField_a_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    vik localvik = a(paramInt).a();
    if (localvik == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131638034));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localvik.a.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(true);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131311056));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302804));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302810));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300079);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131309461);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131303838);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131301909);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131298653);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298652));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299442));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Bixl = new bixl(a());
      j();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Bixl);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new bihc(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new bihd(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.b.setHeaderBgColor(0);
    int i = Color.parseColor("#7d7d7d");
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.b.setTextColor(i, i, i, i, i);
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void n()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void p()
  {
    Object localObject = a(this.jdField_a_of_type_Int).a();
    vik localvik = this.jdField_a_of_type_Bixl.a();
    int i;
    if ((localObject == null) && (localvik != null))
    {
      i = 1;
      if (this.jdField_b_of_type_Int != 1) {
        break label156;
      }
    }
    label156:
    for (localObject = "1";; localObject = "2")
    {
      urp.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.jdField_a_of_type_Int).a(localvik);
      if ((localvik != null) && (localvik.a.jdField_a_of_type_Int == 1)) {
        dov.com.qq.im.capture.view.MusicProviderView.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Bigb.a(0);
      this.jdField_a_of_type_Bigb.a(Message.obtain(null, 18, i, 0));
      return;
      if ((localObject != null) && (localvik != null) && (!((vik)localObject).equals(localvik)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localvik == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public vik a()
  {
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Bigb.e()))
    {
      urk.e("Q.qqstory.publish.edit.EditVideoTag", "getCurrentVideoTag videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bigb.e()), Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return a(this.jdField_a_of_type_Int).a();
  }
  
  public vik a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Bigb.e()))
    {
      urk.e("Q.qqstory.publish.edit.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bigb.e()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131296579));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131296568));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131311068));
    String str1 = this.jdField_a_of_type_Bigb.a.a("video_tag_info");
    if (str1 != null) {}
    try
    {
      if ("web_medal".equals(new JSONObject(str1).optString("src_type"))) {}
      for (this.jdField_a_of_type_Bihg = null;; this.jdField_a_of_type_Bihg = ((bihg)JsonORM.a(new JSONObject(str1), bihg.class)))
      {
        b(this.jdField_a_of_type_Int);
        a(bihh.class, this);
        this.jdField_b_of_type_Int = ((Integer)((spz)sqg.a(10)).b("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
        str1 = "1";
        urp.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.jdField_a_of_type_JavaUtilList = bixh.a(this.jdField_a_of_type_Atmp);
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        urk.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        urk.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void a(int paramInt)
  {
    bixh localbixh = (bixh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbixh == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localbixh.a().remove(localbixh.a());
    localbixh.a(null);
    b(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    urk.b("Q.qqstory.publish.edit.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      c(8);
      return;
    case 34: 
      d();
      paramObject = a(this.jdField_a_of_type_Int);
      bihf localbihf = a();
      if ((paramObject.a() != null) && (!paramObject.a().isEmpty()))
      {
        o();
        if (!paramObject.a(localbihf)) {
          if (paramObject.a() != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.a().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Bixl.a(paramObject.a());
          this.jdField_a_of_type_Bixl.a(paramObject.a());
          this.jdField_a_of_type_Bixl.notifyDataSetChanged();
          a(paramObject.a(), false);
          c(0);
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.a(localbihf);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramObject.a(this.jdField_a_of_type_JavaUtilList);
        o();
      }
      for (;;)
      {
        paramObject.a(localbihf);
        break;
        n();
      }
    }
    b(this.jdField_a_of_type_Int);
    c(8);
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    urk.a("Q.qqstory.publish.edit.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    vik localvik = a(paramInt).a();
    if (localvik == null)
    {
      urk.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    urk.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has tag, tag=%s", Integer.valueOf(paramInt), localvik.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localvik.a.jdField_a_of_type_Long);
    localTagInfoBase.tag_type.set(localvik.a.jdField_a_of_type_Int);
    localTagInfoBase.tag_name.set(localvik.a.jdField_a_of_type_JavaLangString);
    localTagInfoBase.tag_desc.set(localvik.a.jdField_b_of_type_JavaLangString);
    parambitz.a.tagInfoBytes = localTagInfoBase.toByteArray();
  }
  
  public void a(int paramInt, @Nonnull List<vik> paramList, boolean paramBoolean)
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
      k();
      return;
    }
    o();
    vik localvik = this.jdField_a_of_type_Bixl.a();
    localObject = localvik;
    if (!paramList.contains(localvik)) {
      localObject = null;
    }
    a((vik)localObject, false);
    this.jdField_a_of_type_Bixl.a((vik)localObject);
    this.jdField_a_of_type_Bixl.a(paramList);
    this.jdField_a_of_type_Bixl.notifyDataSetChanged();
    return;
    label104:
    if (paramList.isEmpty())
    {
      l();
      a(null, true);
      return;
    }
    o();
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
        this.jdField_a_of_type_Bixl.a(null);
        this.jdField_a_of_type_Bigb.a(0);
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
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bigb.a();
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(int paramInt, @Nonnull List<vik> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    vik localvik;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        k();
        return;
      }
      o();
      localvik = this.jdField_a_of_type_Bixl.a();
      if (paramList.contains(localvik)) {
        break label102;
      }
    }
    for (;;)
    {
      a((vik)localObject, false);
      this.jdField_a_of_type_Bixl.a((vik)localObject);
      this.jdField_a_of_type_Bixl.a(paramList);
      this.jdField_a_of_type_Bixl.notifyDataSetChanged();
      return;
      if (paramList.isEmpty())
      {
        l();
        a(null, true);
        return;
      }
      o();
      return;
      label102:
      localObject = localvik;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302804: 
      this.jdField_a_of_type_Bixl.a(null);
      this.jdField_a_of_type_Bigb.a(0);
      return;
    case 2131302810: 
      paramView = a(bigi.class);
      if (paramView != null)
      {
        paramView = (bigi)paramView;
        if ((!this.jdField_a_of_type_Boolean) && (paramView.a() != 10000) && (this.jdField_a_of_type_Bixl.a() != null))
        {
          this.jdField_a_of_type_Boolean = true;
          babr.a(a(), 230).setMessage(ajjy.a(2131638100)).setPositiveButton(ajjy.a(2131638068), new bihe(this)).show();
          return;
        }
        p();
        return;
      }
      p();
      return;
    case 2131309461: 
      n();
      paramView = a();
      a(this.jdField_a_of_type_Int).a(paramView);
      return;
    }
    this.jdField_a_of_type_Bixl.a(null);
    this.jdField_a_of_type_Bixl.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.jdField_a_of_type_Int).a();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (vik)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_Bixl.a(paramAdapterView);
      this.jdField_a_of_type_Bixl.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.jdField_b_of_type_Int != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      urp.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihb
 * JD-Core Version:    0.7.0.1
 */