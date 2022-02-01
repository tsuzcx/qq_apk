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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class bqhk
  extends bqgi
  implements View.OnClickListener, bljm, bqhq, bqxk
{
  private int jdField_a_of_type_Int;
  private SparseArray<bqxh> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bqhp jdField_a_of_type_Bqhp;
  private bqxl jdField_a_of_type_Bqxl;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = QQStoryContext.a().a().createEntityManager();
  private List<zlk> jdField_a_of_type_JavaUtilList;
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
  
  public bqhk(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
  }
  
  private bqho a()
  {
    bqho localbqho = new bqho();
    bqch localbqch = (bqch)a(bqch.class);
    if (localbqch != null) {
      localbqch.a(localbqho);
    }
    return localbqho;
  }
  
  @Nonnull
  private bqxh a(int paramInt)
  {
    Object localObject2 = (bqxh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new bqxh(this, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
      ((bqxh)localObject1).a();
      if (this.jdField_a_of_type_Bqhp != null)
      {
        localObject2 = new zlk(new zll(this.jdField_a_of_type_Bqhp.jdField_a_of_type_Long, this.jdField_a_of_type_Bqhp.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bqhp.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bqhp.jdField_a_of_type_Int), this.jdField_a_of_type_Bqhp.jdField_b_of_type_Int, this.jdField_a_of_type_Bqhp.c);
        ((bqxh)localObject1).a().add(localObject2);
        ((bqxh)localObject1).a((zlk)localObject2);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(List<zlk> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((zlk)paramList.next()).a.jdField_a_of_type_Int == 1) {
        paramList.remove();
      }
    }
  }
  
  private void a(@Nullable zlk paramzlk, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramzlk == null)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramzlk.a.jdField_a_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    zlk localzlk = a(paramInt).a();
    if (localzlk == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131702718));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localzlk.a.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378421));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369042));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369050));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366048);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376603);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370331);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131368043);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131364530);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364529));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365378));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Bqxl = new bqxl(a());
      j();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Bqxl);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new bqhl(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new bqhm(this));
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
    zlk localzlk = this.jdField_a_of_type_Bqxl.a();
    int i;
    if ((localObject == null) && (localzlk != null))
    {
      i = 1;
      if (this.jdField_b_of_type_Int != 1) {
        break label156;
      }
    }
    label156:
    for (localObject = "1";; localObject = "2")
    {
      yup.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.jdField_a_of_type_Int).a(localzlk);
      if ((localzlk != null) && (localzlk.a.jdField_a_of_type_Int == 1)) {
        dov.com.qq.im.capture.view.MusicProviderView.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Bqgk.a(0);
      this.jdField_a_of_type_Bqgk.a(Message.obtain(null, 18, i, 0));
      return;
      if ((localObject != null) && (localzlk != null) && (!((zlk)localObject).equals(localzlk)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localzlk == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public zlk a()
  {
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Bqgk.e()))
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoTag", "getCurrentVideoTag videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bqgk.e()), Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return a(this.jdField_a_of_type_Int).a();
  }
  
  public zlk a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Bqgk.e()))
    {
      yuk.e("Q.qqstory.publish.edit.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bqgk.e()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362193));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131362180));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378435));
    String str1 = this.jdField_a_of_type_Bqgk.a.a("video_tag_info");
    if (str1 != null) {}
    try
    {
      if ("web_medal".equals(new JSONObject(str1).optString("src_type"))) {}
      for (this.jdField_a_of_type_Bqhp = null;; this.jdField_a_of_type_Bqhp = ((bqhp)JsonORM.a(new JSONObject(str1), bqhp.class)))
      {
        b(this.jdField_a_of_type_Int);
        a(bqhq.class, this);
        this.jdField_b_of_type_Int = ((Integer)((wta)wth.a(10)).b("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
        str1 = "1";
        yup.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.jdField_a_of_type_JavaUtilList = bqxh.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        yuk.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        yuk.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void a(int paramInt)
  {
    bqxh localbqxh = (bqxh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbqxh == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localbqxh.a().remove(localbqxh.a());
    localbqxh.a(null);
    b(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    yuk.b("Q.qqstory.publish.edit.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      c(8);
      return;
    case 34: 
      d();
      paramObject = a(this.jdField_a_of_type_Int);
      bqho localbqho = a();
      if ((paramObject.a() != null) && (!paramObject.a().isEmpty()))
      {
        o();
        if (!paramObject.a(localbqho)) {
          if (paramObject.a() != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.a().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Bqxl.a(paramObject.a());
          this.jdField_a_of_type_Bqxl.a(paramObject.a());
          this.jdField_a_of_type_Bqxl.notifyDataSetChanged();
          a(paramObject.a(), false);
          c(0);
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.a(localbqho);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramObject.a(this.jdField_a_of_type_JavaUtilList);
        o();
      }
      for (;;)
      {
        paramObject.a(localbqho);
        break;
        n();
      }
    }
    b(this.jdField_a_of_type_Int);
    c(8);
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    yuk.a("Q.qqstory.publish.edit.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    zlk localzlk = a(paramInt).a();
    if (localzlk == null)
    {
      yuk.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    yuk.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has tag, tag=%s", Integer.valueOf(paramInt), localzlk.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localzlk.a.jdField_a_of_type_Long);
    localTagInfoBase.tag_type.set(localzlk.a.jdField_a_of_type_Int);
    localTagInfoBase.tag_name.set(localzlk.a.jdField_a_of_type_JavaLangString);
    localTagInfoBase.tag_desc.set(localzlk.a.jdField_b_of_type_JavaLangString);
    parambqua.a.tagInfoBytes = localTagInfoBase.toByteArray();
  }
  
  public void a(int paramInt, @Nonnull List<zlk> paramList, boolean paramBoolean)
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
    zlk localzlk = this.jdField_a_of_type_Bqxl.a();
    localObject = localzlk;
    if (!paramList.contains(localzlk)) {
      localObject = null;
    }
    a((zlk)localObject, false);
    this.jdField_a_of_type_Bqxl.a((zlk)localObject);
    this.jdField_a_of_type_Bqxl.a(paramList);
    this.jdField_a_of_type_Bqxl.notifyDataSetChanged();
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
        this.jdField_a_of_type_Bqxl.a(null);
        this.jdField_a_of_type_Bqgk.a(0);
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
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bqgk.a();
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(int paramInt, @Nonnull List<zlk> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    zlk localzlk;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        k();
        return;
      }
      o();
      localzlk = this.jdField_a_of_type_Bqxl.a();
      if (paramList.contains(localzlk)) {
        break label102;
      }
    }
    for (;;)
    {
      a((zlk)localObject, false);
      this.jdField_a_of_type_Bqxl.a((zlk)localObject);
      this.jdField_a_of_type_Bqxl.a(paramList);
      this.jdField_a_of_type_Bqxl.notifyDataSetChanged();
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
      localObject = localzlk;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Bqxl.a(null);
      this.jdField_a_of_type_Bqgk.a(0);
      continue;
      Object localObject = a(bqgr.class);
      if (localObject != null)
      {
        localObject = (bqgr)localObject;
        if ((!this.jdField_a_of_type_Boolean) && (((bqgr)localObject).a() != 10000) && (this.jdField_a_of_type_Bqxl.a() != null))
        {
          this.jdField_a_of_type_Boolean = true;
          bhlq.a(a(), 230).setMessage(anzj.a(2131702784)).setPositiveButton(anzj.a(2131702752), new bqhn(this)).show();
        }
        else
        {
          p();
        }
      }
      else
      {
        p();
        continue;
        n();
        localObject = a();
        a(this.jdField_a_of_type_Int).a((bqho)localObject);
        continue;
        this.jdField_a_of_type_Bqxl.a(null);
        this.jdField_a_of_type_Bqxl.notifyDataSetChanged();
        a(null, false);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.jdField_a_of_type_Int).a();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (zlk)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_Bqxl.a(paramAdapterView);
      this.jdField_a_of_type_Bqxl.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.jdField_b_of_type_Int != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      yup.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqhk
 * JD-Core Version:    0.7.0.1
 */