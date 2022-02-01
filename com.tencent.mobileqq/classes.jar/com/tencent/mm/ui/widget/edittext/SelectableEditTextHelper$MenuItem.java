package com.tencent.mm.ui.widget.edittext;

public class SelectableEditTextHelper$MenuItem
{
  public static final int ID_MENU_ITEM_COPY = 16908321;
  public static final int ID_MENU_ITEM_CUT = 16908320;
  public static final int ID_MENU_ITEM_PASTE = 16908322;
  public static final int ID_MENU_ITEM_SEARCH = 3;
  public static final int ID_MENU_ITEM_SELECT = 1;
  public static final int ID_MENU_ITEM_SELLECT_ALL = 16908319;
  public static final int ID_MENU_ITEM_TAG = 2;
  public static final int VISIBLE_DEFAULT = 15;
  public static final int VISIBLE_WHEN_CLICK_IN_CONTENT = 4;
  public static final int VISIBLE_WHEN_CLICK_IN_NULL_CONTENT = 2;
  public static final int VISIBLE_WHEN_SELECT_ALL = 1;
  public static final int VISIBLE_WHEN_SELECT_PART = 8;
  public int id;
  public String name;
  public int visibleFlag;
  
  public SelectableEditTextHelper$MenuItem(String paramString, int paramInt)
  {
    this.name = paramString;
    this.id = paramInt;
    this.visibleFlag = 15;
  }
  
  public SelectableEditTextHelper$MenuItem(String paramString, int paramInt1, int paramInt2)
  {
    this.name = paramString;
    this.id = paramInt1;
    this.visibleFlag = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.MenuItem
 * JD-Core Version:    0.7.0.1
 */