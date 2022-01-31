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

public class bjxw
  extends bjwu
  implements View.OnClickListener, bfpc, bjyc, bknw
{
  private int jdField_a_of_type_Int;
  private SparseArray<bknt> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aukn jdField_a_of_type_Aukn = QQStoryContext.a().a().createEntityManager();
  private bjyb jdField_a_of_type_Bjyb;
  private bknx jdField_a_of_type_Bknx;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private List<vvg> jdField_a_of_type_JavaUtilList;
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
  
  public bjxw(@NonNull bjww parambjww)
  {
    super(parambjww);
  }
  
  private bjya a()
  {
    bjya localbjya = new bjya();
    bjst localbjst = (bjst)a(bjst.class);
    if (localbjst != null) {
      localbjst.a(localbjya);
    }
    return localbjya;
  }
  
  @Nonnull
  private bknt a(int paramInt)
  {
    Object localObject2 = (bknt)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new bknt(this, this.jdField_a_of_type_Aukn);
      ((bknt)localObject1).a();
      if (this.jdField_a_of_type_Bjyb != null)
      {
        localObject2 = new vvg(new vvh(this.jdField_a_of_type_Bjyb.jdField_a_of_type_Long, this.jdField_a_of_type_Bjyb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bjyb.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bjyb.jdField_a_of_type_Int), this.jdField_a_of_type_Bjyb.jdField_b_of_type_Int, this.jdField_a_of_type_Bjyb.c);
        ((bknt)localObject1).a().add(localObject2);
        ((bknt)localObject1).a((vvg)localObject2);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(List<vvg> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((vvg)paramList.next()).a.jdField_a_of_type_Int == 1) {
        paramList.remove();
      }
    }
  }
  
  private void a(@Nullable vvg paramvvg, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramvvg == null)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramvvg.a.jdField_a_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    vvg localvvg = a(paramInt).a();
    if (localvvg == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajyc.a(2131703819));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localvvg.a.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376865));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368429));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368435));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365676);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375209);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369513);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131367526);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131364211);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364210));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365010));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Bknx = new bknx(a());
      j();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Bknx);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new bjxx(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new bjxy(this));
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
    vvg localvvg = this.jdField_a_of_type_Bknx.a();
    int i;
    if ((localObject == null) && (localvvg != null))
    {
      i = 1;
      if (this.jdField_b_of_type_Int != 1) {
        break label156;
      }
    }
    label156:
    for (localObject = "1";; localObject = "2")
    {
      vel.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.jdField_a_of_type_Int).a(localvvg);
      if ((localvvg != null) && (localvvg.a.jdField_a_of_type_Int == 1)) {
        dov.com.qq.im.capture.view.MusicProviderView.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Bjww.a(0);
      this.jdField_a_of_type_Bjww.a(Message.obtain(null, 18, i, 0));
      return;
      if ((localObject != null) && (localvvg != null) && (!((vvg)localObject).equals(localvvg)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localvvg == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public vvg a()
  {
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Bjww.e()))
    {
      veg.e("Q.qqstory.publish.edit.EditVideoTag", "getCurrentVideoTag videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bjww.e()), Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return a(this.jdField_a_of_type_Int).a();
  }
  
  public vvg a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Bjww.e()))
    {
      veg.e("Q.qqstory.publish.edit.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bjww.e()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362120));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131362109));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131376878));
    String str1 = this.jdField_a_of_type_Bjww.a.a("video_tag_info");
    if (str1 != null) {}
    try
    {
      if ("web_medal".equals(new JSONObject(str1).optString("src_type"))) {}
      for (this.jdField_a_of_type_Bjyb = null;; this.jdField_a_of_type_Bjyb = ((bjyb)JsonORM.a(new JSONObject(str1), bjyb.class)))
      {
        b(this.jdField_a_of_type_Int);
        a(bjyc.class, this);
        this.jdField_b_of_type_Int = ((Integer)((tcv)tdc.a(10)).b("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
        str1 = "1";
        vel.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.jdField_a_of_type_JavaUtilList = bknt.a(this.jdField_a_of_type_Aukn);
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        veg.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        veg.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void a(int paramInt)
  {
    bknt localbknt = (bknt)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbknt == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localbknt.a().remove(localbknt.a());
    localbknt.a(null);
    b(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    veg.b("Q.qqstory.publish.edit.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      c(8);
      return;
    case 34: 
      d();
      paramObject = a(this.jdField_a_of_type_Int);
      bjya localbjya = a();
      if ((paramObject.a() != null) && (!paramObject.a().isEmpty()))
      {
        o();
        if (!paramObject.a(localbjya)) {
          if (paramObject.a() != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.a().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Bknx.a(paramObject.a());
          this.jdField_a_of_type_Bknx.a(paramObject.a());
          this.jdField_a_of_type_Bknx.notifyDataSetChanged();
          a(paramObject.a(), false);
          c(0);
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.a(localbjya);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramObject.a(this.jdField_a_of_type_JavaUtilList);
        o();
      }
      for (;;)
      {
        paramObject.a(localbjya);
        break;
        n();
      }
    }
    b(this.jdField_a_of_type_Int);
    c(8);
  }
  
  public void a(int paramInt, @NonNull bkkm parambkkm)
  {
    veg.a("Q.qqstory.publish.edit.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    vvg localvvg = a(paramInt).a();
    if (localvvg == null)
    {
      veg.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    veg.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has tag, tag=%s", Integer.valueOf(paramInt), localvvg.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localvvg.a.jdField_a_of_type_Long);
    localTagInfoBase.tag_type.set(localvvg.a.jdField_a_of_type_Int);
    localTagInfoBase.tag_name.set(localvvg.a.jdField_a_of_type_JavaLangString);
    localTagInfoBase.tag_desc.set(localvvg.a.jdField_b_of_type_JavaLangString);
    parambkkm.a.tagInfoBytes = localTagInfoBase.toByteArray();
  }
  
  public void a(int paramInt, @Nonnull List<vvg> paramList, boolean paramBoolean)
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
    vvg localvvg = this.jdField_a_of_type_Bknx.a();
    localObject = localvvg;
    if (!paramList.contains(localvvg)) {
      localObject = null;
    }
    a((vvg)localObject, false);
    this.jdField_a_of_type_Bknx.a((vvg)localObject);
    this.jdField_a_of_type_Bknx.a(paramList);
    this.jdField_a_of_type_Bknx.notifyDataSetChanged();
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
        this.jdField_a_of_type_Bknx.a(null);
        this.jdField_a_of_type_Bjww.a(0);
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
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bjww.a();
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(int paramInt, @Nonnull List<vvg> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    vvg localvvg;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        k();
        return;
      }
      o();
      localvvg = this.jdField_a_of_type_Bknx.a();
      if (paramList.contains(localvvg)) {
        break label102;
      }
    }
    for (;;)
    {
      a((vvg)localObject, false);
      this.jdField_a_of_type_Bknx.a((vvg)localObject);
      this.jdField_a_of_type_Bknx.a(paramList);
      this.jdField_a_of_type_Bknx.notifyDataSetChanged();
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
      localObject = localvvg;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368429: 
      this.jdField_a_of_type_Bknx.a(null);
      this.jdField_a_of_type_Bjww.a(0);
      return;
    case 2131368435: 
      paramView = a(bjxd.class);
      if (paramView != null)
      {
        paramView = (bjxd)paramView;
        if ((!this.jdField_a_of_type_Boolean) && (paramView.a() != 10000) && (this.jdField_a_of_type_Bknx.a() != null))
        {
          this.jdField_a_of_type_Boolean = true;
          bbcv.a(a(), 230).setMessage(ajyc.a(2131703885)).setPositiveButton(ajyc.a(2131703853), new bjxz(this)).show();
          return;
        }
        p();
        return;
      }
      p();
      return;
    case 2131375209: 
      n();
      paramView = a();
      a(this.jdField_a_of_type_Int).a(paramView);
      return;
    }
    this.jdField_a_of_type_Bknx.a(null);
    this.jdField_a_of_type_Bknx.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.jdField_a_of_type_Int).a();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (vvg)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_Bknx.a(paramAdapterView);
      this.jdField_a_of_type_Bknx.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.jdField_b_of_type_Int != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      vel.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxw
 * JD-Core Version:    0.7.0.1
 */