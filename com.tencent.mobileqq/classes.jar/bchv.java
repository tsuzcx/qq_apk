import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.view.IndexBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bchv
  extends akhz
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final bchd jdField_a_of_type_Bchd;
  bchk jdField_a_of_type_Bchk;
  private final bchs jdField_a_of_type_Bchs;
  private bchy jdField_a_of_type_Bchy;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<aidf, bchm> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<aidf> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public bchv(bchs parambchs, TroopChatPie paramTroopChatPie)
  {
    super(parambchs.jdField_a_of_type_AndroidContentContext, parambchs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambchs.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = parambchs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = parambchs.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Bchs = parambchs;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Bchd = new bchd(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bchy = new bchy(this);
    d();
  }
  
  private void a(int paramInt, bchx parambchx)
  {
    aidf localaidf = (aidf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambchx.c.setImageBitmap(a(localaidf.jdField_a_of_type_JavaLangString, 2));
    Object localObject = bchn.b(localaidf);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localaidf.v;
    }
    localObject = new bamb((CharSequence)localObject, 16).a();
    parambchx.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bdrv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambchx.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject);
    parambchx.jdField_a_of_type_JavaLangString = localaidf.jdField_a_of_type_JavaLangString;
    parambchx.jdField_a_of_type_Int = paramInt;
    bchx.a(parambchx).setTag(parambchx);
    bchx.a(parambchx).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), parambchx, localaidf);
    c(parambchx, localaidf);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localaidf))
    {
      parambchx.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Bchy.jdField_a_of_type_Boolean) {
        break label209;
      }
      parambchx.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parambchx, localaidf);
      b(parambchx, localaidf);
      return;
      parambchx.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label209:
      parambchx.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(aidf paramaidf)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Map.Entry localEntry = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int i = 0;
    Object localObject1 = localEntry;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((aidf)((Map.Entry)localObject1).getKey()).equals(paramaidf)) {
        localObject1 = (bchm)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramaidf = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramaidf.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramaidf.next();
      if (j >= i) {
        break label157;
      }
      localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    for (;;)
    {
      j += 1;
      break label98;
      i += 1;
      break;
      label157:
      if ((j != i) && (localObject1 != null))
      {
        localObject2 = (bchm)localEntry.getValue();
        int m = ((bchm)localObject2).jdField_a_of_type_Int - ((bchm)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new bchm(k, ((bchm)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((bchx)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Bchy.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Bchy.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Bchd.b();
    } while (!this.jdField_a_of_type_Bchd.a());
    aidf localaidf = (aidf)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localaidf);
      label79:
      if (paramView.isChecked()) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bchd.a();
      if ((this.jdField_a_of_type_Bchy.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bchk == null)) {
        break;
      }
      this.jdField_a_of_type_Bchk.a();
      return;
      b(localaidf);
      a(localaidf);
      break label79;
    }
  }
  
  private void a(bchx parambchx)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Bchd.a(parambchx.jdField_a_of_type_AndroidWidgetRelativeLayout);
    parambchx.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
    this.jdField_a_of_type_Bchd.a((String)localObject);
    this.jdField_a_of_type_Bchy.a(parambchx.c);
    localObject = (aidf)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      parambchx.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Bchy.jdField_a_of_type_Boolean)
    {
      parambchx.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      parambchx.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    parambchx.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(bchx parambchx, aidf paramaidf)
  {
    if (parambchx.jdField_a_of_type_AndroidViewView != null)
    {
      bcpg localbcpg = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localbcpg == null) || (!localbcpg.b(paramaidf.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parambchx.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambchx.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(aidf paramaidf)
  {
    paramaidf = (bchm)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramaidf);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (paramaidf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramaidf);
      }
      int i = paramaidf.jdField_a_of_type_Int;
      int j = paramaidf.jdField_a_of_type_Int;
      localEditable.delete(i, paramaidf.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (bchx)paramView.getTag();
    paramView = ((bchx)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    aidf localaidf = (aidf)getItem(((bchx)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Bchy.a())
      {
        this.jdField_a_of_type_Bchy.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localaidf);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (bcpg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (((this.jdField_a_of_type_Bchk != null) && (paramView.b(localaidf.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Bchk != null) && (!this.jdField_a_of_type_Bchy.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Bchk.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localaidf.v)) || (!localaidf.v.equals(localaidf.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localaidf);
      a(localaidf);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localaidf.v))
      {
        paramView = (View)localObject;
        if (localaidf.v.equals(localaidf.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(bchx parambchx, aidf paramaidf)
  {
    if (parambchx.b != null)
    {
      if (paramaidf.jdField_a_of_type_Boolean)
      {
        paramaidf = bcpx.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        parambchx.b.setBackgroundDrawable(paramaidf);
        parambchx.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    parambchx.b.setVisibility(8);
  }
  
  private void c(aidf paramaidf)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramaidf)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramaidf });
    }
    Object localObject;
    do
    {
      return;
      localObject = bchn.a(paramaidf);
      localObject = bciq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramaidf.jdField_a_of_type_JavaLangString, (String)localObject, bchn.a(paramaidf), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (bchn.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      bchm localbchm = new bchm(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramaidf, localbchm);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localbchm, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(bchx parambchx, aidf paramaidf)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramaidf.jdField_a_of_type_JavaLangString))
    {
      bchx.a(parambchx).setVisibility(0);
      paramaidf = bbtx.a().a(true, false);
      bchx.a(parambchx).setText(paramaidf.jdField_a_of_type_JavaLangString);
      paramaidf = bcpx.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramaidf.b);
      bchx.a(parambchx).setBackgroundDrawable(paramaidf);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(paramaidf.jdField_a_of_type_JavaLangString))
    {
      bchx.a(parambchx).setVisibility(0);
      paramaidf = bbtx.a().a(false, true);
      bchx.a(parambchx).setText(paramaidf.jdField_a_of_type_JavaLangString);
      paramaidf = bcpx.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramaidf.b);
      bchx.a(parambchx).setBackgroundDrawable(paramaidf);
      return;
    }
    bchx.a(parambchx).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bchs.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bchw(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Bchs.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  aidf a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        aidf localaidf = (aidf)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localaidf.jdField_a_of_type_JavaLangString != null) && (localaidf.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localaidf;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public bchy a()
  {
    return this.jdField_a_of_type_Bchy;
  }
  
  public List<aidf> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localArrayList;
  }
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bchs.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(bchk parambchk)
  {
    this.jdField_a_of_type_Bchk = parambchk;
  }
  
  public void a(bcia parambcia)
  {
    this.jdField_a_of_type_JavaUtilList = parambcia.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = parambcia.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambcia.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = parambcia.jdField_a_of_type_JavaLangString;
    this.b = parambcia.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bchd.a();
    if (TextUtils.isEmpty(parambcia.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    for (;;)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged start  " + System.currentTimeMillis());
      }
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged end  " + System.currentTimeMillis());
      }
      return;
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "unCheckItem ", paramString.toString() });
    }
    a(paramString);
    notifyDataSetChanged();
  }
  
  public void a(List<aidf> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    return "0".equals(((aidf)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
    {
      i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (i != 1) {
        break label72;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Bchy.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bchd != null) {
      this.jdField_a_of_type_Bchd.c();
    }
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (a())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label88;
      }
      if (i == 0) {
        break label69;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562772, paramViewGroup, false);
      label37:
      paramViewGroup = new bchx(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (i == 0) {
        break label99;
      }
      a(paramViewGroup);
      return paramView;
      i = 0;
      break;
      label69:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562771, paramViewGroup, false);
      break label37;
      label88:
      paramViewGroup = (bchx)paramView.getTag();
    }
    label99:
    a(paramInt, paramViewGroup);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368527: 
      b(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchv
 * JD-Core Version:    0.7.0.1
 */