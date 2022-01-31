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

public class baem
  extends aimb
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final badu jdField_a_of_type_Badu;
  baeb jdField_a_of_type_Baeb;
  private final baej jdField_a_of_type_Baej;
  private baep jdField_a_of_type_Baep;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<agau, baed> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<agau> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public baem(baej parambaej, TroopChatPie paramTroopChatPie)
  {
    super(parambaej.jdField_a_of_type_AndroidContentContext, parambaej.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambaej.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = parambaej.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = parambaej.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Baej = parambaej;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Badu = new badu(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Baep = new baep(this);
    d();
  }
  
  private void a(int paramInt, baeo parambaeo)
  {
    agau localagau = (agau)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambaeo.c.setImageBitmap(a(localagau.jdField_a_of_type_JavaLangString, 2));
    Object localObject = baee.b(localagau);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localagau.v;
    }
    localObject = new ayju((CharSequence)localObject, 16).a();
    parambaeo.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bboe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambaeo.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject);
    parambaeo.jdField_a_of_type_JavaLangString = localagau.jdField_a_of_type_JavaLangString;
    parambaeo.jdField_a_of_type_Int = paramInt;
    baeo.a(parambaeo).setTag(parambaeo);
    baeo.a(parambaeo).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), parambaeo, localagau);
    c(parambaeo, localagau);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localagau))
    {
      parambaeo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Baep.jdField_a_of_type_Boolean) {
        break label209;
      }
      parambaeo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parambaeo, localagau);
      b(parambaeo, localagau);
      return;
      parambaeo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label209:
      parambaeo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(agau paramagau)
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
      if (((agau)((Map.Entry)localObject1).getKey()).equals(paramagau)) {
        localObject1 = (baed)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramagau = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramagau.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramagau.next();
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
        localObject2 = (baed)localEntry.getValue();
        int m = ((baed)localObject2).jdField_a_of_type_Int - ((baed)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new baed(k, ((baed)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((baeo)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Baep.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Baep.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Badu.b();
    } while (!this.jdField_a_of_type_Badu.a());
    agau localagau = (agau)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localagau);
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
      this.jdField_a_of_type_Badu.a();
      if ((this.jdField_a_of_type_Baep.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Baeb == null)) {
        break;
      }
      this.jdField_a_of_type_Baeb.a();
      return;
      b(localagau);
      a(localagau);
      break label79;
    }
  }
  
  private void a(baeo parambaeo)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Badu.a(parambaeo.jdField_a_of_type_AndroidWidgetRelativeLayout);
    parambaeo.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
    this.jdField_a_of_type_Badu.a((String)localObject);
    this.jdField_a_of_type_Baep.a(parambaeo.c);
    localObject = (agau)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      parambaeo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Baep.jdField_a_of_type_Boolean)
    {
      parambaeo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      parambaeo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    parambaeo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(baeo parambaeo, agau paramagau)
  {
    if (parambaeo.jdField_a_of_type_AndroidViewView != null)
    {
      balw localbalw = (balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localbalw == null) || (!localbalw.b(paramagau.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parambaeo.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambaeo.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(agau paramagau)
  {
    paramagau = (baed)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramagau);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (paramagau != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramagau);
      }
      int i = paramagau.jdField_a_of_type_Int;
      int j = paramagau.jdField_a_of_type_Int;
      localEditable.delete(i, paramagau.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (baeo)paramView.getTag();
    paramView = ((baeo)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    agau localagau = (agau)getItem(((baeo)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Baep.a())
      {
        this.jdField_a_of_type_Baep.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localagau);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (((this.jdField_a_of_type_Baeb != null) && (paramView.b(localagau.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Baeb != null) && (!this.jdField_a_of_type_Baep.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Baeb.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localagau.v)) || (!localagau.v.equals(localagau.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localagau);
      a(localagau);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localagau.v))
      {
        paramView = (View)localObject;
        if (localagau.v.equals(localagau.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(baeo parambaeo, agau paramagau)
  {
    if (parambaeo.b != null)
    {
      if (paramagau.jdField_a_of_type_Boolean)
      {
        paramagau = bamn.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        parambaeo.b.setBackgroundDrawable(paramagau);
        parambaeo.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    parambaeo.b.setVisibility(8);
  }
  
  private void c(agau paramagau)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramagau)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramagau });
    }
    Object localObject;
    do
    {
      return;
      localObject = baee.a(paramagau);
      localObject = bafh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramagau.jdField_a_of_type_JavaLangString, (String)localObject, baee.a(paramagau), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (baee.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      baed localbaed = new baed(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramagau, localbaed);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localbaed, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(baeo parambaeo, agau paramagau)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramagau.jdField_a_of_type_JavaLangString))
    {
      baeo.a(parambaeo).setVisibility(0);
      paramagau = azrd.a().a(true, false);
      baeo.a(parambaeo).setText(paramagau.jdField_a_of_type_JavaLangString);
      paramagau = bamn.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramagau.b);
      baeo.a(parambaeo).setBackgroundDrawable(paramagau);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(paramagau.jdField_a_of_type_JavaLangString))
    {
      baeo.a(parambaeo).setVisibility(0);
      paramagau = azrd.a().a(false, true);
      baeo.a(parambaeo).setText(paramagau.jdField_a_of_type_JavaLangString);
      paramagau = bamn.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramagau.b);
      baeo.a(parambaeo).setBackgroundDrawable(paramagau);
      return;
    }
    baeo.a(parambaeo).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Baej.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new baen(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Baej.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
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
  
  agau a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        agau localagau = (agau)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localagau.jdField_a_of_type_JavaLangString != null) && (localagau.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localagau;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public baep a()
  {
    return this.jdField_a_of_type_Baep;
  }
  
  public List<agau> a()
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
    paramView = this.jdField_a_of_type_Baej.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(baeb parambaeb)
  {
    this.jdField_a_of_type_Baeb = parambaeb;
  }
  
  public void a(baer parambaer)
  {
    this.jdField_a_of_type_JavaUtilList = parambaer.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = parambaer.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambaer.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = parambaer.jdField_a_of_type_JavaLangString;
    this.b = parambaer.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Badu.a();
    if (TextUtils.isEmpty(parambaer.jdField_a_of_type_JavaLangString))
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
  
  public void a(List<agau> paramList)
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
    return "0".equals(((agau)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
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
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Baep.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Badu != null) {
      this.jdField_a_of_type_Badu.c();
    }
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562553, paramViewGroup, false);
      label37:
      paramViewGroup = new baeo(paramView);
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562552, paramViewGroup, false);
      break label37;
      label88:
      paramViewGroup = (baeo)paramView.getTag();
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
    case 2131368344: 
      b(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baem
 * JD-Core Version:    0.7.0.1
 */