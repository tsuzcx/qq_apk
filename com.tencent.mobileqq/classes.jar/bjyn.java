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

public class bjyn
  extends bjxl
  implements View.OnClickListener, bfpt, bjyt, bkon
{
  private int jdField_a_of_type_Int;
  private SparseArray<bkok> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aukp jdField_a_of_type_Aukp = QQStoryContext.a().a().createEntityManager();
  private bjys jdField_a_of_type_Bjys;
  private bkoo jdField_a_of_type_Bkoo;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private List<vvd> jdField_a_of_type_JavaUtilList;
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
  
  public bjyn(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  private bjyr a()
  {
    bjyr localbjyr = new bjyr();
    bjtk localbjtk = (bjtk)a(bjtk.class);
    if (localbjtk != null) {
      localbjtk.a(localbjyr);
    }
    return localbjyr;
  }
  
  @Nonnull
  private bkok a(int paramInt)
  {
    Object localObject2 = (bkok)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new bkok(this, this.jdField_a_of_type_Aukp);
      ((bkok)localObject1).a();
      if (this.jdField_a_of_type_Bjys != null)
      {
        localObject2 = new vvd(new vve(this.jdField_a_of_type_Bjys.jdField_a_of_type_Long, this.jdField_a_of_type_Bjys.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bjys.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bjys.jdField_a_of_type_Int), this.jdField_a_of_type_Bjys.jdField_b_of_type_Int, this.jdField_a_of_type_Bjys.c);
        ((bkok)localObject1).a().add(localObject2);
        ((bkok)localObject1).a((vvd)localObject2);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(List<vvd> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((vvd)paramList.next()).a.jdField_a_of_type_Int == 1) {
        paramList.remove();
      }
    }
  }
  
  private void a(@Nullable vvd paramvvd, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramvvd == null)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramvvd.a.jdField_a_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    vvd localvvd = a(paramInt).a();
    if (localvvd == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131703830));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localvvd.a.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376867));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368429));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368435));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365675);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375211);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369512);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131367526);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131364210);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364209));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365009));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Bkoo = new bkoo(a());
      j();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Bkoo);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new bjyo(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new bjyp(this));
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
    vvd localvvd = this.jdField_a_of_type_Bkoo.a();
    int i;
    if ((localObject == null) && (localvvd != null))
    {
      i = 1;
      if (this.jdField_b_of_type_Int != 1) {
        break label156;
      }
    }
    label156:
    for (localObject = "1";; localObject = "2")
    {
      vei.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.jdField_a_of_type_Int).a(localvvd);
      if ((localvvd != null) && (localvvd.a.jdField_a_of_type_Int == 1)) {
        dov.com.qq.im.capture.view.MusicProviderView.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_Bjxn.a(0);
      this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 18, i, 0));
      return;
      if ((localObject != null) && (localvvd != null) && (!((vvd)localObject).equals(localvvd)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localvvd == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public vvd a()
  {
    if ((this.jdField_a_of_type_Int < 0) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Bjxn.e()))
    {
      ved.e("Q.qqstory.publish.edit.EditVideoTag", "getCurrentVideoTag videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bjxn.e()), Integer.valueOf(this.jdField_a_of_type_Int) });
      return null;
    }
    return a(this.jdField_a_of_type_Int).a();
  }
  
  public vvd a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Bjxn.e()))
    {
      ved.e("Q.qqstory.publish.edit.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bjxn.e()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362119));
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131362108));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131376880));
    String str1 = this.jdField_a_of_type_Bjxn.a.a("video_tag_info");
    if (str1 != null) {}
    try
    {
      if ("web_medal".equals(new JSONObject(str1).optString("src_type"))) {}
      for (this.jdField_a_of_type_Bjys = null;; this.jdField_a_of_type_Bjys = ((bjys)JsonORM.a(new JSONObject(str1), bjys.class)))
      {
        b(this.jdField_a_of_type_Int);
        a(bjyt.class, this);
        this.jdField_b_of_type_Int = ((Integer)((tcs)tcz.a(10)).b("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
        if (this.jdField_b_of_type_Int != 1) {
          break;
        }
        str1 = "1";
        vei.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.jdField_a_of_type_JavaUtilList = bkok.a(this.jdField_a_of_type_Aukp);
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        ved.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ved.b("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void a(int paramInt)
  {
    bkok localbkok = (bkok)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbkok == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localbkok.a().remove(localbkok.a());
    localbkok.a(null);
    b(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      c(8);
      return;
    case 34: 
      d();
      paramObject = a(this.jdField_a_of_type_Int);
      bjyr localbjyr = a();
      if ((paramObject.a() != null) && (!paramObject.a().isEmpty()))
      {
        o();
        if (!paramObject.a(localbjyr)) {
          if (paramObject.a() != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.a().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Bkoo.a(paramObject.a());
          this.jdField_a_of_type_Bkoo.a(paramObject.a());
          this.jdField_a_of_type_Bkoo.notifyDataSetChanged();
          a(paramObject.a(), false);
          c(0);
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.a(localbjyr);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramObject.a(this.jdField_a_of_type_JavaUtilList);
        o();
      }
      for (;;)
      {
        paramObject.a(localbjyr);
        break;
        n();
      }
    }
    b(this.jdField_a_of_type_Int);
    c(8);
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    ved.a("Q.qqstory.publish.edit.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    vvd localvvd = a(paramInt).a();
    if (localvvd == null)
    {
      ved.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    ved.a("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has tag, tag=%s", Integer.valueOf(paramInt), localvvd.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localvvd.a.jdField_a_of_type_Long);
    localTagInfoBase.tag_type.set(localvvd.a.jdField_a_of_type_Int);
    localTagInfoBase.tag_name.set(localvvd.a.jdField_a_of_type_JavaLangString);
    localTagInfoBase.tag_desc.set(localvvd.a.jdField_b_of_type_JavaLangString);
    parambkld.a.tagInfoBytes = localTagInfoBase.toByteArray();
  }
  
  public void a(int paramInt, @Nonnull List<vvd> paramList, boolean paramBoolean)
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
    vvd localvvd = this.jdField_a_of_type_Bkoo.a();
    localObject = localvvd;
    if (!paramList.contains(localvvd)) {
      localObject = null;
    }
    a((vvd)localObject, false);
    this.jdField_a_of_type_Bkoo.a((vvd)localObject);
    this.jdField_a_of_type_Bkoo.a(paramList);
    this.jdField_a_of_type_Bkoo.notifyDataSetChanged();
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
        this.jdField_a_of_type_Bkoo.a(null);
        this.jdField_a_of_type_Bjxn.a(0);
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
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Bjxn.a();
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(int paramInt, @Nonnull List<vvd> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    vvd localvvd;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        k();
        return;
      }
      o();
      localvvd = this.jdField_a_of_type_Bkoo.a();
      if (paramList.contains(localvvd)) {
        break label102;
      }
    }
    for (;;)
    {
      a((vvd)localObject, false);
      this.jdField_a_of_type_Bkoo.a((vvd)localObject);
      this.jdField_a_of_type_Bkoo.a(paramList);
      this.jdField_a_of_type_Bkoo.notifyDataSetChanged();
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
      localObject = localvvd;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368429: 
      this.jdField_a_of_type_Bkoo.a(null);
      this.jdField_a_of_type_Bjxn.a(0);
      return;
    case 2131368435: 
      paramView = a(bjxu.class);
      if (paramView != null)
      {
        paramView = (bjxu)paramView;
        if ((!this.jdField_a_of_type_Boolean) && (paramView.a() != 10000) && (this.jdField_a_of_type_Bkoo.a() != null))
        {
          this.jdField_a_of_type_Boolean = true;
          bbdj.a(a(), 230).setMessage(ajya.a(2131703896)).setPositiveButton(ajya.a(2131703864), new bjyq(this)).show();
          return;
        }
        p();
        return;
      }
      p();
      return;
    case 2131375211: 
      n();
      paramView = a();
      a(this.jdField_a_of_type_Int).a(paramView);
      return;
    }
    this.jdField_a_of_type_Bkoo.a(null);
    this.jdField_a_of_type_Bkoo.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.jdField_a_of_type_Int).a();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (vvd)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_Bkoo.a(paramAdapterView);
      this.jdField_a_of_type_Bkoo.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.jdField_b_of_type_Int != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      vei.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyn
 * JD-Core Version:    0.7.0.1
 */