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

public class bmjx
  extends bmiv
  implements View.OnClickListener, bhqp, bmkd, bmzx
{
  private int jdField_a_of_type_Int;
  private SparseArray<bmzu> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awbw jdField_a_of_type_Awbw = QQStoryContext.a().a().createEntityManager();
  private bmkc jdField_a_of_type_Bmkc;
  private bmzy jdField_a_of_type_Bmzy;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private List<xjv> jdField_a_of_type_JavaUtilList;
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
  
  public bmjx(@NonNull bmix parambmix)
  {
    super(parambmix);
  }
  
  private bmkb a()
  {
    bmkb localbmkb = new bmkb();
    bmeu localbmeu = (bmeu)a(bmeu.class);
    if (localbmeu != null) {
      localbmeu.a(localbmkb);
    }
    return localbmkb;
  }
  
  @Nonnull
  private bmzu a(int paramInt)
  {
    Object localObject2 = (bmzu)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new bmzu(this, this.jdField_a_of_type_Awbw);
      ((bmzu)localObject1).a();
      if (this.jdField_a_of_type_Bmkc != null)
      {
        localObject2 = new xjv(new xjw(this.jdField_a_of_type_Bmkc.jdField_a_of_type_Long, this.jdField_a_of_type_Bmkc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bmkc.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bmkc.jdField_a_of_type_Int), this.jdField_a_of_type_Bmkc.jdField_b_of_type_Int, this.jdField_a_of_type_Bmkc.c);
        ((bmzu)localObject1).a().add(localObject2);
        ((bmzu)localObject1).a((xjv)localObject2);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(List<xjv> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((xjv)paramList.next()).a.jdField_a_of_type_Int == 1) {
        paramList.remove();
      }
    }
  }
  
  private void a(@Nullable xjv paramxjv, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramxjv == null)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramxjv.a.jdField_a_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    xjv localxjv = a(paramInt).a();
    if (localxjv == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131704202));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localxjv.a.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377381));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368613));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368621));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365759);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375693);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369774);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131367654);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131364273);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364272));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365094));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Bmzy = new bmzy(a());
      j();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Bmzy);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new bmjy(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new bmjz(this));
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
    xjv localxjv = this.jdField_a_of_type_Bmzy.a();
    int i;
    if ((localObject == null) && (localxjv != null))
    {
      i = 1;
      if (this.jdField_b_of_type_Int != 1) {
        break label156;
      }
    }
    label156:
    for (localObject = "1";; localObject = "2")
    {
      wta.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.jdField_a_of_type_Int).a(localxjv);
      if ((localxjv != null) && (localxjv.a.jdField_a_of_type_Int == 1)) {
        dov.com.qq.im.capture.view.MusicProviderView.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Bmix.a(0);
      this.jdField_a_of_type_Bmix.a(Message.obtain(null, 18, i, 0));
      return;
      if ((localObject != null) && (localxjv != null) && (!((xjv)localObject).equals(localxjv)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localxjv == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public xjv a()
  {
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Bmix.e()))
    {
      wsv.e("Q.qqstory.publish.edit.EditVideoTag", "getCurrentVideoTag videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bmix.e()), Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return a(this.jdField_a_of_type_Int).a();
  }
  
  public xjv a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Bmix.e()))
    {
      wsv.e("Q.qqstory.publish.edit.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bmix.e()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362124));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131362113));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131377394));
    String str1 = this.jdField_a_of_type_Bmix.a.a("video_tag_info");
    if (str1 != null) {}
    try
    {
      if ("web_medal".equals(new JSONObject(str1).optString("src_type"))) {}
      for (this.jdField_a_of_type_Bmkc = null;; this.jdField_a_of_type_Bmkc = ((bmkc)JsonORM.a(new JSONObject(str1), bmkc.class)))
      {
        b(this.jdField_a_of_type_Int);
        a(bmkd.class, this);
        this.jdField_b_of_type_Int = ((Integer)((urk)urr.a(10)).b("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
        str1 = "1";
        wta.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.jdField_a_of_type_JavaUtilList = bmzu.a(this.jdField_a_of_type_Awbw);
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        wsv.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        wsv.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void a(int paramInt)
  {
    bmzu localbmzu = (bmzu)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbmzu == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localbmzu.a().remove(localbmzu.a());
    localbmzu.a(null);
    b(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    wsv.b("Q.qqstory.publish.edit.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      c(8);
      return;
    case 34: 
      d();
      paramObject = a(this.jdField_a_of_type_Int);
      bmkb localbmkb = a();
      if ((paramObject.a() != null) && (!paramObject.a().isEmpty()))
      {
        o();
        if (!paramObject.a(localbmkb)) {
          if (paramObject.a() != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.a().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Bmzy.a(paramObject.a());
          this.jdField_a_of_type_Bmzy.a(paramObject.a());
          this.jdField_a_of_type_Bmzy.notifyDataSetChanged();
          a(paramObject.a(), false);
          c(0);
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.a(localbmkb);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramObject.a(this.jdField_a_of_type_JavaUtilList);
        o();
      }
      for (;;)
      {
        paramObject.a(localbmkb);
        break;
        n();
      }
    }
    b(this.jdField_a_of_type_Int);
    c(8);
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    wsv.a("Q.qqstory.publish.edit.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    xjv localxjv = a(paramInt).a();
    if (localxjv == null)
    {
      wsv.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    wsv.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has tag, tag=%s", Integer.valueOf(paramInt), localxjv.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localxjv.a.jdField_a_of_type_Long);
    localTagInfoBase.tag_type.set(localxjv.a.jdField_a_of_type_Int);
    localTagInfoBase.tag_name.set(localxjv.a.jdField_a_of_type_JavaLangString);
    localTagInfoBase.tag_desc.set(localxjv.a.jdField_b_of_type_JavaLangString);
    parambmwn.a.tagInfoBytes = localTagInfoBase.toByteArray();
  }
  
  public void a(int paramInt, @Nonnull List<xjv> paramList, boolean paramBoolean)
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
    xjv localxjv = this.jdField_a_of_type_Bmzy.a();
    localObject = localxjv;
    if (!paramList.contains(localxjv)) {
      localObject = null;
    }
    a((xjv)localObject, false);
    this.jdField_a_of_type_Bmzy.a((xjv)localObject);
    this.jdField_a_of_type_Bmzy.a(paramList);
    this.jdField_a_of_type_Bmzy.notifyDataSetChanged();
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
        this.jdField_a_of_type_Bmzy.a(null);
        this.jdField_a_of_type_Bmix.a(0);
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
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bmix.a();
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(int paramInt, @Nonnull List<xjv> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    xjv localxjv;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        k();
        return;
      }
      o();
      localxjv = this.jdField_a_of_type_Bmzy.a();
      if (paramList.contains(localxjv)) {
        break label102;
      }
    }
    for (;;)
    {
      a((xjv)localObject, false);
      this.jdField_a_of_type_Bmzy.a((xjv)localObject);
      this.jdField_a_of_type_Bmzy.a(paramList);
      this.jdField_a_of_type_Bmzy.notifyDataSetChanged();
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
      localObject = localxjv;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368613: 
      this.jdField_a_of_type_Bmzy.a(null);
      this.jdField_a_of_type_Bmix.a(0);
      return;
    case 2131368621: 
      paramView = a(bmje.class);
      if (paramView != null)
      {
        paramView = (bmje)paramView;
        if ((!this.jdField_a_of_type_Boolean) && (paramView.a() != 10000) && (this.jdField_a_of_type_Bmzy.a() != null))
        {
          this.jdField_a_of_type_Boolean = true;
          bdcd.a(a(), 230).setMessage(alpo.a(2131704268)).setPositiveButton(alpo.a(2131704236), new bmka(this)).show();
          return;
        }
        p();
        return;
      }
      p();
      return;
    case 2131375693: 
      n();
      paramView = a();
      a(this.jdField_a_of_type_Int).a(paramView);
      return;
    }
    this.jdField_a_of_type_Bmzy.a(null);
    this.jdField_a_of_type_Bmzy.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.jdField_a_of_type_Int).a();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (xjv)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_Bmzy.a(paramAdapterView);
      this.jdField_a_of_type_Bmzy.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.jdField_b_of_type_Int != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      wta.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjx
 * JD-Core Version:    0.7.0.1
 */